package com.zy.usercenter.model.protocol.resp

/**
 *@author:zhangyue
 *@date:2021/7/22
 * 服务器响应的用户实体类型
 */
data class RespUserEntity(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)