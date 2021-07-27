package com.zy.common.log

import android.util.Log
import com.zy.common.BuildConfig

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
object LogUtils {
    private var log:ILog
    init {
        log=NormalLog()
    }

    fun setLogTarget(logInstance:ILog){
        log=logInstance
    }

    fun setLogLevel(_minLevel:Int){
        log.setLogLevel(_minLevel)
    }

    fun log(logType: LogType,_log:String){
        log.log(logType,_log)
    }
}