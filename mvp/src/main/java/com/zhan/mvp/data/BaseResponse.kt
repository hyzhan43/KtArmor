package com.zhan.mvp.data

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
data class BaseResponse<T>(var data: T?, var errorCode: Int = -1, var errorMsg: String = "")