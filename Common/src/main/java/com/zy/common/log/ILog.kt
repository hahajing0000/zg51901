package com.zy.common.log

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
interface ILog {
    fun log(logType: LogType,_log:String)
    fun setLogLevel(_minLevel:Int)
}