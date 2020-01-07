package com.zhan.hy.ktarmor.common.bean

import com.zhan.mvp.bean.KResponse
import com.zhan.mvp.constant.Const

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
data class BaseResponse<T>(
    var data: T?,
    var errorCode: Int = -1,
    var errorMsg: String = Const.MESSAGE_EMPTY
) : KResponse<T> {

    override fun isSuccess(): Boolean = errorCode == 0

    override fun getKData(): T? = data

    override fun getKMessage(): String? = errorMsg
}