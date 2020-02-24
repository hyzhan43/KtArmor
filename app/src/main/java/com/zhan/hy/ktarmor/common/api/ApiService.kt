package com.zhan.hy.ktarmor.common.api

import com.zhan.hy.ktarmor.common.bean.BaseResponse
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.mvp.anotation.BaseUrl
import kotlinx.coroutines.Deferred
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
@BaseUrl(API.BASE_URL)
interface ApiService {

    @POST(API.LOGIN)
    suspend fun loginAsync(
        @Query("username") username: String,
        @Query("password") password: String
    ): BaseResponse<LoginRsp>
}