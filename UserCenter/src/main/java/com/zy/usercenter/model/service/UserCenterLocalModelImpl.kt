package com.zy.usercenter.model.service

import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import kotlinx.coroutines.Deferred

/**
 *@author:zhangyue
 *@date:2021/7/31
 * 从本地（sqlite）获取或者提交数据
 */
class UserCenterLocalModelImpl: UserCenterContract.UserCenterModel  {
    override fun register(entity: UserEntitiy): Deferred<BaseRespEntity<RespUserEntity>> {
        TODO("Not yet implemented")
    }
}