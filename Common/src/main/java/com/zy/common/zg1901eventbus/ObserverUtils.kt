package com.zy.common.zg1901eventbus

/**
 *@author:zhangyue
 *@date:2021/7/27
 */
object ObserverUtils {

    /**
     * 此处要支持多个Observable
     */
    private val observableMap:MutableMap<String,ZObservable>
    init{
        observableMap= mutableMapOf<String,ZObservable>()
    }

    private val observable:ZObservable by lazy { ZObservable() }

    /**
     * 获取被观察者
     */
    fun getFinalObservable(key: String):ZObservable?{
        return getObservable(key)
    }

    /**
     * 加入被观察者
     */
    @Synchronized
    fun addObservable(key:String,observable:ZObservable= ZObservable()):ZObservable?{
        if (observableMap.containsKey(key)){
            return observableMap.get(key)
        }
        return observableMap.put(key,observable)
    }

    /**
     * 删除被观察者
     */
    @Synchronized
    fun removeObservable(key:String){
        if (observableMap.containsKey(key)){
            observableMap.remove(key)
        }
    }

    /**
     * 获取被观察者
     */
    @Synchronized
    private fun getObservable(key:String):ZObservable?{
        if (!observableMap.containsKey(key)){
            return addObservable(key)
        }
        return observableMap.get(key)
    }

    /**
     * 清空所有被观察者
     */
    @Synchronized
    fun clearObservable(){
        observableMap.clear()
    }

}