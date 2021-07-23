package com.zy.net.protocol.resp

/**
 *@author:zhangyue
 *@date:2021/7/22
 * 服务器返回的基础类型结构
 */
data class BaseRespEntity<T>(var code:Int,var data:T,var msg:String) {
}