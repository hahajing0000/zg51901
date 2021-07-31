package com.zy.mvpcore

import com.zy.common.log.LogType
import com.zy.common.log.LogUtils
import com.zy.common.zg1901eventbus.ObserverUtils
import com.zy.common.zg1901eventbus.ZObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.lang.ref.SoftReference

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
abstract class BasePresenter<Repo:BaseRepository<*>,V:IVew>(_view:V):ZObserver {
    private lateinit var job:Job
    protected val presenterScope:CoroutineScope by lazy { CoroutineScope(Dispatchers.Main+ job) }
    protected lateinit var mRepository: Repo
    protected lateinit var mView:SoftReference<V>
    init {
        mRepository=createRepository()
        mView=SoftReference<V>(_view)
        job= Job()

//        val finalObservable = ObserverUtils.getFinalObservable("")!!
//        finalObservable.registerObserver(this)
    }

    abstract fun createRepository(): Repo


    /**
     * 释放回收资源
     */
    override fun notify(vararg args: String?) {
        LogUtils.log(LogType.WORNNING,"job cancel is called....")
        job.cancel()
    }
}