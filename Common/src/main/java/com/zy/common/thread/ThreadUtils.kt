package com.zy.common.thread

import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.SystemClock
import android.text.format.Time
import java.util.concurrent.*

/**
 *@author:zhangyue
 *@date:2021/7/27
 */

private val handler:Handler=Handler(Looper.getMainLooper())
fun <T> T.runOnUi(method:T.()->Unit){
    handler.post{
        method()
    }
}


/**
 *     //    Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
//    Thread({()->
//
//    }).start()

//    ThreadPoolExecutor

//    val threadPoolExecutor= ThreadPoolExecutor(0, Int.MAX_VALUE,10,TimeUnit.SECONDS,BlockingQueue<Any>(),
//        ThreadFactory {
//            Thread()
//        })

//    val result = Executors.newCachedThreadPool().submit(object : Callable<String> {
//        override fun call(): String {
//            SystemClock.sleep(3000)
//            return ""
//        }
//
//    })
//    val asyncResult = result.get()
 Desc:创建子线程任务并执行
 */
fun <T> T.runOnAsync(method: T.() -> Unit){

    Executors.newFixedThreadPool(5).submit(object :Runnable{
        override fun run() {
            method()
        }

    })

}