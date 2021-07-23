package com.zy.mvpcore

import java.lang.ref.SoftReference

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
abstract class BasePresenter<Repo:BaseRepository<*>,V:IVew>(_view:V) {
    protected lateinit var mRepository: Repo
    protected lateinit var mView:SoftReference<V>
    init {
        mRepository=createRepository()
        mView=SoftReference<V>(_view)
    }

    abstract fun createRepository(): Repo
}