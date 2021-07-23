package com.zy.usercenter.model.api

import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
interface UserCenterApi {

    @POST("api/User/register")
    fun register(@Body params:UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
}