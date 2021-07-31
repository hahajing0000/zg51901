package com.zy.common.zg1901eventbus

/**
 *@author:zhangyue
 *@date:2021/7/31
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class BusAnnotation(val Key:String) {
}