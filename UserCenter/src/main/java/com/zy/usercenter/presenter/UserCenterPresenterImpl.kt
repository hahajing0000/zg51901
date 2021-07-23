package com.zy.usercenter.presenter

import com.zy.net.protocol.resp.BaseRespEntity
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.model.protocol.resp.RespUserEntity
import com.zy.usercenter.repository.UserCenterRepositoryImpl
import com.zy.net.rxjava.BllObserver
import com.zy.net.rxjava.ObservableUtils

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
class UserCenterPresenterImpl(_view:UserCenterContract.UserCenterView): UserCenterContract.UserCenterPresenter(_view) {
    override fun register(entity: UserEntitiy) {
        ObservableUtils.getInstance().doObservable(mRepository.register(entity),object :
            BllObserver<BaseRespEntity<RespUserEntity>>() {
            override fun onNext(t: BaseRespEntity<RespUserEntity>) {
                super.onNext(t)
                mView.get()!!.registerSuccess(t)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                mView.get()!!.registerFailed(e)
            }
        },mView.get()!!.getLifecycleOwner())

    }


    override fun createRepository(): UserCenterContract.UserCenterRepository {
        return UserCenterRepositoryImpl()
    }
}