package com.zy.mvpcore.view

import com.zy.mvpcore.BasePresenter
import com.zy.mvpcore.BaseRepository
import com.zy.mvpcore.IModel
import com.zy.mvpcore.IVew

/**
 *@author:zhangyue
 *@date:2021/7/21
 */
abstract class BaseMVPActivity<P:BasePresenter<*,*>>:BaseActivity() {
    protected lateinit var mPresenter: P

    init {
        mPresenter=createPresenter()
    }

    abstract fun createPresenter(): P

}