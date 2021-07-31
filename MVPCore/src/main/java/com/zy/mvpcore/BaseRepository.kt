package com.zy.mvpcore

import android.os.Build
import androidx.annotation.RequiresApi
import com.zy.mvpcore.annotation.Model

/**
 *@author:zhangyue
 *@date:2021/7/21
 * DESC:数据仓库层
 */
abstract class BaseRepository<M:IModel> {
//    protected lateinit var mModel:M
    init {
//        mModel=createModel()
        initModel()
    }

    /**
     * 初始化Model 实现一个Repo对应多个Model
     * 使用注解结合反射来完成Model属性的获取及对应修饰Model类型的初始化
     */
    private fun initModel() {
        val thatType = this::class.java
        val declaredFields = thatType.declaredFields
        //获取Repo的所有字段 进行判断
        if (declaredFields.size>0){
            var hasModel:Boolean=false
            //循环遍历所有的Field
            for (field in declaredFields){
                val annotation = field.getAnnotation(Model::class.java)
                //已找到Model注销修饰的字段
                if (annotation!=null){
                    //打开当前Field的可访问性
                    field.isAccessible=true
                    var typeName:String =""
                    if (Build.VERSION.SDK_INT>=28){
                        typeName = field.genericType.typeName
                    }
                    else{
                        typeName= field.type.name
                    }

                    val fieldType = Class.forName(typeName)
                    val instance = fieldType.newInstance()
                    field.set(this,instance)
                    hasModel=true
                }
            }
            if (!hasModel){
                throw java.lang.IllegalStateException("no set any model....")
            }

        }else{
            throw IllegalStateException("no set any field....")
        }
    }

//    abstract fun createModel(): M
}