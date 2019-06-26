package com.zhan.hy.ktarmor.account.model

import com.zhan.hy.ktarmor.common.BaseModel

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
object LoginModel : BaseModel() {

    fun login(account: String, password: String)
            = apiService.login(account, password)
}