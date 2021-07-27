package com.zy.common.log

import android.util.Log

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
class LocalDBLog:ILog {
    override fun log(logType: LogType, _log: String) {
        Log.d("123", "log: 。。。。。。。。。。。。。。。。。。。。。。。")
    }

    override fun setLogLevel(_minLevel: Int) {
        TODO("Not yet implemented")
    }

}