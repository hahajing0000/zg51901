package com.zy.usercenter.model.service

import android.os.SystemClock
import com.zy.net.RetrofitFactory
import com.zy.net.protocol.resp.BaseRespEntity

import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.api.UserCenterApi
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

/**
 *@author:zhangyue
 *@date:2021/7/22
 * 从网络上获取或者提交数据
 */
class UserCenterRemoteModelImpl:UserCenterContract.UserCenterModel {
    override fun register(entity: UserEntitiy): Deferred<BaseRespEntity<RespUserEntity>> {
        val service = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.register(entity)
    }

}