package com.zy.usercenter.presenter

import com.zy.net.ext.doResult
import com.zy.usercenter.contract.UserCenterContract
import com.zy.usercenter.model.protocol.req.UserEntitiy
import com.zy.usercenter.repository.UserCenterRepositoryImpl
import kotlinx.coroutines.launch

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
class UserCenterPresenterImpl(val _view:UserCenterContract.UserCenterView): UserCenterContract.UserCenterPresenter(_view) {

    override fun register(entity: UserEntitiy) {

//        ObservableUtils.getInstance().doObservable(mRepository.register(entity),object :
//            BllObserver<BaseRespEntity<RespUserEntity>>() {
//            override fun onNext(t: BaseRespEntity<RespUserEntity>) {
//                super.onNext(t)
//                mView.get()!!.registerSuccess(t)
//            }
//
//            override fun onError(e: Throwable) {
//                super.onError(e)
//                mView.get()!!.registerFailed(e)
//            }
//        },mView.get()!!.getLifecycleOwner())


        presenterScope.launch {
            mRepository.register(entity).doResult({
                mView.get()!!.registerSuccess(it)
            },{
                mView.get()!!.registerFailed(Throwable())
            },{

            })

        }

    }


    override fun createRepository(): UserCenterContract.UserCenterRepository {
        return UserCenterRepositoryImpl()
    }
}