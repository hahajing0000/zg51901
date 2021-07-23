package com.zy.mvpcore

import androidx.lifecycle.LifecycleOwner

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
interface IVew {
    /**
     * 获取生命周期拥有者
     */
    fun getLifecycleOwner():LifecycleOwner
}