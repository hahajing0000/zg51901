package com.zy.usercenter.model.protocol.req

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
data class UserEntitiy(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)