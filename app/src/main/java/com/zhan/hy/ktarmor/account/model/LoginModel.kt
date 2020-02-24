package com.zhan.hy.ktarmor.account.model

import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.common.api.ApiManager
import com.zhan.hy.ktarmor.common.bean.BaseResponse

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
object LoginModel {

    suspend fun login(account: String, password: String): BaseResponse<LoginRsp> {
        return ApiManager.apiService.loginAsync(account, password).await()
    }
}