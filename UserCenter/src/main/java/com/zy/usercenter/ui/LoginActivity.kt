package com.zy.usercenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.zy.common.sp.SPPropDelegate
import com.zy.common.zg1901eventbus.ObserverUtils
import com.zy.common.zg1901eventbus.ZObserver
import com.zy.mvpcore.view.BaseMVPActivity
import com.zy.usercenter.R
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.presenter.UserCenterPresenterImpl
import com.zy.usercenter.repository.UserCenterRepositoryImpl
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseMVPActivity<UserCenterPresenterImpl>(),UserCenterContract.UserCenterView ,ZObserver{

    private var username:String by SPPropDelegate<String>("username","testuser")

    override fun createPresenter(): UserCenterPresenterImpl {
        return UserCenterPresenterImpl(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initEvent() {
        btn_login_login.setOnClickListener {
//            val phoneNumber:String=et_login_phonenumber.text.trim().toString()
//            val pwd:String=et_login_pwd.text.trim().toString()
//
//            mPresenter.register(UserEntitiy("2021-01-01",0,pwd,"1",phoneNumber))
//            username="xiaoming"
//            Log.d("123", "username : $username")

            startService(Intent(this@LoginActivity,MyService::class.java))

        }
    }

    override fun initData(savedInstanceState:Bundle?) {
        ObserverUtils.getFinalObservable().registerObserver(this)
    }

    /**
     * 该方法是在OnStop中调用 所有可以用于释放资源 比如 ： 移除Handler  停止动画。。。
     */
    override fun releaseResource() {
        ObserverUtils.getFinalObservable().unRegisterObserver(this)
    }

    override fun <T> registerSuccess(data: T) {
        Log.d("123", "registerSuccess: ${data.toString()}")
    }

    override fun registerFailed(throwable: Throwable) {
        Log.w("123", "registerFailed: ${throwable.message}")
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        return this
    }

    override fun notify(vararg args: String?) {
        Log.d("123", "notify: ....")
        for (arg in args){
            Log.d("123", "notify: ${arg}")
        }
    }

}