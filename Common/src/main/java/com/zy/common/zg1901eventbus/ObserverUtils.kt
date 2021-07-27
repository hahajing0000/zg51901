package com.zy.common.zg1901eventbus

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
object ObserverUtils {

    /**
     * 此处要支持多个Observable  你们自己考虑
     */

    private val observable:ZObservable by lazy { ZObservable() }

    fun getFinalObservable():ZObservable{
        return observable
    }

}