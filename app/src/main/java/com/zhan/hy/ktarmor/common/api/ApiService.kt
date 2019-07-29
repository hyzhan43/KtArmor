package com.zhan.hy.ktarmor.common.api

import com.zhan.hy.ktarmor.common.bean.BaseResponse
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import kotlinx.coroutines.Deferred
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
interface ApiService {

    @POST(API.LOGIN)
    fun loginAsync(@Query("username") username: String,
                   @Query("password") password: String): Deferred<BaseResponse<LoginRsp>>
}