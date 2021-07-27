package com.zy.common.zg1901eventbus

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
interface ZObserver {
    /**
     * 通知
     */
    fun notify(vararg args:String?)
}