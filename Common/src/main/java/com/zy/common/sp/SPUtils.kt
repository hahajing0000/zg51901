package com.zy.common.sp

import android.content.Context
import android.content.SharedPreferences
import com.zy.common.app.MyApplication
import java.lang.IllegalArgumentException

/**
 *@author:zhangyue
 *@date:2021/7/23
 */
object SPUtils {
    private val sp:SharedPreferences by lazy {
        createSharedPreferences()
    }

    /**
     * 创建SP
     */
    private fun createSharedPreferences():SharedPreferences {
        return MyApplication.getAppContext().getSharedPreferences("zg51901", Context.MODE_PRIVATE)
    }

    /**
     * 向SP存储值
     */
    fun <T> putValue(key:String,value:T,isCommit:Boolean){
        sp.edit().apply(){
            when(value){
                is String -> putString(key,value)
                is Float -> putFloat(key,value)
                is Boolean -> putBoolean(key,value)
                is Long -> putLong(key,value)
                is Int -> putInt(key,value)
                else -> throw IllegalArgumentException("you use type is unknown...")
            }
            if (isCommit)commit() else apply()
        }
    }

    /**
     * 从SP中取值
     */
    fun <T> getValue(key:String,defaultValue:T):T{
        return when(defaultValue){
            is String -> sp.getString(key,defaultValue)
            is Float -> sp.getFloat(key,defaultValue)
            is Boolean -> sp.getBoolean(key,defaultValue)
            is Int -> sp.getInt(key,defaultValue)
            is Long -> sp.getLong(key,defaultValue)
            else->throw IllegalArgumentException("you get value type is unknown...")
        } as T
    }
}