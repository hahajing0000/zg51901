package com.zy.mvpcore.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zy.mvpcore.common.ConstValue

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(savedInstanceState)
        initEvent()

        if (isClearStatBar()){
            ClearStatBar()
        }
    }

    /**
     * 跳转到另一个Activity
     */
    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(this@BaseActivity,otherActivity))
    }

    /**
     * 带参数跳转到另一个Activity
     */
    fun jumpActivity(otherActivity:Class<*>,params:Bundle?){
        val intent:Intent=Intent(this@BaseActivity,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }

    /**
     * 显示消息
     */
    fun showMsg(msg:String){
        Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState:Bundle?)

    /**
     * 释放资源
     */
    abstract fun releaseResource()


    /**
     * 是否实现沉浸式
     */
    protected open fun isClearStatBar(): Boolean{
        return true
    }

    /**
     * 去掉状态栏 实现沉浸式
     */
    fun ClearStatBar(){

    }


    override fun onStop() {
        super.onStop()
        releaseResource()
    }
}