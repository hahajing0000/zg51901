package com.zy.mvpcore.view

import com.zy.mvpcore.BasePresenter
import com.zy.mvpcore.BaseRepository
import com.zy.mvpcore.IModel
import com.zy.mvpcore.IVew
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
abstract class BaseMVPActivity<P:BasePresenter<*,*>>:BaseActivity(),CoroutineScope {
    protected lateinit var mPresenter: P
    lateinit var job: Job

    init {
        mPresenter=createPresenter()
        job= Job()
//        CoroutineScope(Dispatchers.Main)
    }

    abstract fun createPresenter(): P

    override val coroutineContext: CoroutineContext
        get() = job

    override fun releaseResource() {
        job.cancel()
    }

}