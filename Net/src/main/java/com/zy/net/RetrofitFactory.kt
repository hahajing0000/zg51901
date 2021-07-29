package com.zy.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zy.common.Constant
import com.zy.common.sp.SPPropDelegate
import com.zy.net.api.TokenApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
class RetrofitFactory private constructor(){

    /**
     * 使用属性委托间接存储到SP
     */
    private var token:String by SPPropDelegate<String>("token","",false)

    companion object{
        val retrofitInstance:RetrofitFactory by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }
    }

    val retorfit: Retrofit
    init {
        retorfit=Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
//            .addConverterFactory(XMLConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(createOkHttpClient())
            .build()
    }

    /**
     * 设置自定义的OkHttpClient
     */
    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .writeTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .connectTimeout(Constant.TIMEOUT,TimeUnit.SECONDS)
            .addNetworkInterceptor(createLogInterceptor())
            .addInterceptor(createTokenInterceptor())
            .build()
    }

    /**
     * 创建处理Token的自定义拦截器
     */
    private fun createTokenInterceptor(): Interceptor {
        val interceptor= Interceptor {
            val request=it.request()
            var response:Response?=null
            /**
             * 先从SP中获取已存在的Token
             * 存在：直接加到请求头中
             * 不存在：从后台获取token然后添加到请求头 缓存到SP中
             */
            if (token.isNotBlank()){
//                setRequestHeader(request,it)
                response=doRequest(request,it)
            }else{
                response=it.proceed(request)
            }

            if (response!!.code()==401){
                requestToken()
                doRequest(request,it)
            }
            else{
                response
            }

        }
        return interceptor
    }

    /**
     * 设置请求头并执行
     */
    private fun setRequestHeader(request: Request,chain: Interceptor.Chain):Request{
        //设置到请求头
        return request.newBuilder()
            .addHeader("Authorization", "bearer $token")
            .build()
//        return chain.proceed(newRequest)
    }

    /**
     * 获取Token然后设置到请求头
     */
    private fun doRequest(request: Request,chain: Interceptor.Chain):Response{

        return chain.proceed(setRequestHeader(request,chain))
    }

    private fun requestToken() {
        //获取token
        val tokenApi:TokenApi=create(TokenApi::class.java)
        val tokenService = tokenApi.getToken("password", Constant.AUTHCODE, "")
        val result = tokenService!!.execute()
        //拿到的token
        val resultToken = result.body()!!.access_token
        /**
         * 将从服务器获取到的Token存入到SP中
         */
        token=resultToken
    }

    /**
     * 创建日志拦截器
     */
    private fun createLogInterceptor(): Interceptor {
        val logInterceptor=HttpLoggingInterceptor()
        logInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    /**
     * 通过传入的请求接口类型返回具体的实体对象
     */
    fun <T> create(service:Class<T>):T{
        return retorfit.create(service)
    }
}