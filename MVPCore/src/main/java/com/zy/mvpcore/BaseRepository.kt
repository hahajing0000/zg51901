package com.zy.mvpcore

/**
 *@author:zhangyue
 *@date:2021/7/21
 * DESC:数据仓库层
 */
abstract class BaseRepository<M:IModel> {
    protected lateinit var mModel:M
    init {
        mModel=createModel()
    }

    abstract fun createModel(): M
}