package com.zhan.hy.ktarmor.account.model

import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.common.api.ApiManager
import com.zhan.hy.ktarmor.common.bean.BaseResponse
import com.zhan.mvp.mvp.BaseModel

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
object LoginModel : BaseModel() {

    suspend fun login(account: String, password: String): BaseResponse<LoginRsp> {
        return launchIO { ApiManager.apiService.loginAsync(account, password).await() }
    }
}