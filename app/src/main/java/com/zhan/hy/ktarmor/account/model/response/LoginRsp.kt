package com.zhan.hy.ktarmor.account.model.response

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
data class LoginRsp(
        var icon: String,
        var type: String,
        var collectIds: List<Int>,
        var username: String
)