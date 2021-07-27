package com.zy.common.zg1901eventbus

import kotlin.concurrent.fixedRateTimer

/**
 *@author:zhangyue
 *@date:2021/7/27
 * 被观察者
 */
class ZObservable {
    /**
     * 存放的是注册进来所有观察者
     */
    private val observers:MutableList<ZObserver> by lazy { mutableListOf<ZObserver>() }

    /**
     * 注册观察者
     */
    fun registerObserver(observer:ZObserver):Boolean
    {
        if (observer !in observers){
            observers.add(observer)
            return true
        }else{
            return false
        }
    }

    /**
     * 注销观察者
     */
    fun unRegisterObserver(observer: ZObserver):Boolean{
        if (observer in observers){
            observers.remove(observer)
            return true
        }
        return false
    }

    /**
     * 移除所有的观察者
     */
    fun clearObservers(){
        observers.clear()
    }

    /**
     * 通知所有的观察者
     */
    fun notifyAll(vararg args:String?){
        for (observer in observers){
            observer.notify(*args)
        }
    }
}