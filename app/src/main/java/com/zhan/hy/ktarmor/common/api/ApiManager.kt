package com.zhan.hy.ktarmor.common.api

import com.zhan.mvp.http.RetrofitFactory

/**
 *  @author:  hyzhan
 *  @date:    2019/7/5
 *  @desc:    TODO
 */
object ApiManager {

    val apiService by lazy {
        RetrofitFactory.create(ApiService::class.java)
    }
}