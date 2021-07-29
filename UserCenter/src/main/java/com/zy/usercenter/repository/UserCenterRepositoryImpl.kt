package com.zy.usercenter.repository

import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import com.zy.usercenter.model.service.UserCenterModelImpl
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
class UserCenterRepositoryImpl: UserCenterContract.UserCenterRepository() {
    override fun register(entity: UserEntitiy): Deferred<BaseRespEntity<RespUserEntity>> {
        return mModel.register(entity)
    }


    override fun createModel(): UserCenterContract.UserCenterModel {
        return UserCenterModelImpl()
    }
}