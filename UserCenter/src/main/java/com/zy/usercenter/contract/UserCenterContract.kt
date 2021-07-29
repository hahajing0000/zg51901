package com.zy.usercenter.contract

import com.zy.mvpcore.BasePresenter
import com.zy.mvpcore.BaseRepository
import com.zy.mvpcore.IModel
import com.zy.mvpcore.IVew
import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
interface UserCenterContract {
    interface UserCenterModel:IModel{
        fun register(entity:UserEntitiy):Deferred<BaseRespEntity<RespUserEntity>>
    }

    abstract class UserCenterRepository:BaseRepository<UserCenterModel>(){
        abstract fun register(entity:UserEntitiy):Deferred<BaseRespEntity<RespUserEntity>>
    }

    interface UserCenterView:IVew{
        fun <T> registerSuccess(data:T)
        fun registerFailed(throwable: Throwable)
    }

    abstract class UserCenterPresenter(view:UserCenterView):BasePresenter<UserCenterRepository,UserCenterView>(view){
        abstract fun register(entity: UserEntitiy)
    }
}