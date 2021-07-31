package com.zy.usercenter.repository

import com.zy.common.log.LogType
import com.zy.common.log.LogUtils
import com.zy.mvpcore.annotation.Model
import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import com.zy.usercenter.model.service.UserCenterLocalModelImpl
import com.zy.usercenter.model.service.UserCenterRemoteModelImpl
import kotlinx.coroutines.Deferred

/**
 *@author:zhangyue
 *@date:2021/7/22 1:N
 */
class UserCenterRepositoryImpl: UserCenterContract.UserCenterRepository() {

    @Model
    private val remoteModel:UserCenterRemoteModelImpl?=null

    @Model
    private val localModel:UserCenterLocalModelImpl?=null

    override fun register(entity: UserEntitiy): Deferred<BaseRespEntity<RespUserEntity>> {

        LogUtils.log(LogType.DEBUG,localModel.toString())
        return remoteModel!!.register(entity)
    }

}