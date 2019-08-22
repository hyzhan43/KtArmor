package com.zhan.mvp.bean

/**
 *  @author:  hyzhan
 *  @date:    2019/8/7
 *  @desc:    TODO
 */
interface KResponse<T> {

    fun isSuccess(): Boolean

    fun getKMessage(): String?

    fun getKData(): T?
}