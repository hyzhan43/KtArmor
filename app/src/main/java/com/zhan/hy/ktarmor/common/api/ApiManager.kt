package com.zhan.hy.ktarmor.common.api

import com.zhan.mvp.http.RetrofitFactory
import com.zhan.mvp.mvp.BaseModel

/**
 *  @author:  hyzhan
 *  @date:    2019/7/5
 *  @desc:    TODO
 */
object ApiManager {

    val apiService by lazy {
        RetrofitFactory.instance.create(ApiService::class.java)
    }
}