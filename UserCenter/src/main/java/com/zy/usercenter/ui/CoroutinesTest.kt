package com.zy.usercenter.ui

import android.os.SystemClock
import kotlinx.coroutines.*
import java.lang.Runnable
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 *@author:zhangyue
 *@date:2021/7/27
 */

fun main() {

    GlobalScope.launch {

    }

    val mainScope = MainScope()
    mainScope.launch {

    }
//    mainScope.cancel()
//    newFixedThreadPoolContext(3, "ctx1").use {
//        println("newFixedThreadPoolContext thread name is ${Thread.currentThread().name}")
//        runBlocking(it) {
//
//            withContext(it) {
//                println("withContext1 thread name is ${Thread.currentThread().name}")
//            }
//
//        }
//
//        newSingleThreadContext("ctx2").use { itt ->
//            println("newSingleThreadContext thread name is ${Thread.currentThread().name}")
//            runBlocking {
//                withContext(itt) {
//                    println("withContext2 thread name is ${Thread.currentThread().name}")
//                }
//            }
//        }
//
//        runBlocking {
//            launch(Dispatchers.IO) {
//
//            }
//
//            launch(Dispatchers.Main) {
//
//            }
//        }
//    }
//
//    runBlocking() {
//
//    }

}

suspend fun method2() {
    delay(500L)
}

suspend fun method3() {
    delay(600L)
}

