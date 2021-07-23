package com.zy.net.protocol.resp

/**
 *@author:zhangyue
 *@date:2021/7/22
 */
data class TokenRespEntity(var access_token:String,var token_type:String,var expires_in:Int=0) {
}