package com.zy.common.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import java.util.*

/**
 *@author:zhangyue
 *@date:2021/7/23
 */
class MyApplication:Application() {
    lateinit var acitivies:MutableList<Activity>
    init {
        registerActivityLifecycleCallbacks(object:Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {
                Log.d("123", "onActivityPaused: ${activity.toString()}")
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d("123", "onActivityStarted: ${activity.toString()}")
            }

            override fun onActivityDestroyed(activity: Activity) {
                acitivies.remove(activity)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d("123", "onActivityStopped: ${activity.toString()}")
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d("123", "onActivityCreated: ${activity.toString()}")
                acitivies.add(activity)
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d("123", "onActivityResumed: ${activity.toString()}")
            }

        })
    }

    override fun onCreate() {
        super.onCreate()
        mContext=this
    }

    companion object{
        var mContext:Application?=null
        fun getAppContext(): Context {
            return mContext!!
        }
    }

    fun exitApp(){
        for (activity in acitivies){
            activity.finish()
        }
    }
}