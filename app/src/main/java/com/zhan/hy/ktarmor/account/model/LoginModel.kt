package com.zhan.hy.ktarmor.account.model

import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.common.ApiModel
import com.zhan.mvp.mvp.BaseContract
import com.zhan.mvp.mvp.BaseModel

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginModel : ApiModel(), LoginContract.Model {

    override fun login(account: String, password: String, callback: (String, Boolean) -> Unit) {

        callback.invoke("看的见我吗", true)
    }
}