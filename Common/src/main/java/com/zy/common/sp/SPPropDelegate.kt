package com.zy.common.sp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *@author:zhangyue
 *@date:2021/7/23
 */
class SPPropDelegate<T>(
    private val key:String,
    private val defaultValue:T,
    private val isCommit:Boolean=true
):ReadWriteProperty<Any?,T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        var finalKey=if (key.isNotBlank()) property.name else key
        return SPUtils.getValue(finalKey,defaultValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        SPUtils.putValue(key,value,isCommit)
    }
}