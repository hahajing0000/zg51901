package com.zy.net.ext

import com.zy.common.log.LogType
import com.zy.common.log.LogUtils
import com.zy.net.protocol.resp.BaseRespEntity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@author:zhangyue
 *@date:2021/7/29 ,completed:Deferred<T>.()->Unit
 */
suspend fun <T> Deferred<T>.doResult(success:(BaseRespEntity<*>)->Unit,failed:(Throwable)->Unit,completed:Deferred<T>.()->Unit){
    try {
        val result= this.await() as BaseRespEntity<*>
        if (result.code==200){
            withContext(Dispatchers.Main){
                success(result)
            }

        }
        else{
            withContext(Dispatchers.Main){
                failed(Throwable(result.msg))
            }
        }
    }
    catch (ex:Throwable){
        /**
         * TODO:此处ex如果外包没有访问直接在withContext内部访问将报错
         * 待研究
         */
        val exMsg= ex
        withContext(Dispatchers.Main){
            failed(exMsg)
        }
    }
    finally {
        withContext(Dispatchers.Main){
            completed()
        }
    }
}