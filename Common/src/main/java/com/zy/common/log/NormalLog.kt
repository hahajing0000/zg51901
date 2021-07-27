package com.zy.common.log

import android.util.Log
import com.zy.common.BuildConfig
import java.lang.RuntimeException

/**
 *@author:zhangyue
 *@date:2021/7/27
 * 标准输出到Logcat
 */
class NormalLog :ILog {
    private val TAG:String="123"
    private val pix="---> ";
    private val isDebug:Boolean=BuildConfig.DEBUG

    /**
     * 设置的日志级别 默认是0 也就是所有级别都输出
     */
    private var minLevel:Int=0

    /**
     * 设置日志输出级别
     */
    override fun setLogLevel(_minLevel:Int){
        minLevel=_minLevel
    }

    override fun log(logType: LogType, _log: String) {

        when(logType){
            LogType.INFO->i(_log)
            LogType.DEBUG->d(_log)
            LogType.WORNNING->w(_log)
            LogType.ERROR->e(_log)
            else->throw RuntimeException("log type is not exists")
        }
    }

    private fun d(log:String,tag:String=TAG){
        if(isDebug&&minLevel<=LogType.DEBUG.ordinal){
            Log.d(TAG, "$pix : $log")
        }

    }

    private fun i(log:String,tag:String=TAG){
        if(isDebug&&minLevel<=LogType.INFO.ordinal){
            Log.i(TAG, "$pix : $log")
        }

    }

    private fun w(log:String,tag:String=TAG){
        if(isDebug&&minLevel<=LogType.WORNNING.ordinal){
            Log.w(TAG, "$pix : $log")
        }

    }

    private fun e(log:String,tag:String=TAG){
        if(isDebug&&minLevel<=LogType.ERROR.ordinal){
            Log.e(TAG, "$pix : $log")
        }

    }

}