package com.zhan.hy.ktarmor

import com.zhan.hy.ktarmor.common.api.API
import com.zhan.mvp.http.BaseOkHttpClient
import com.zhan.mvp.http.BaseRetrofitConfig
import okhttp3.OkHttpClient

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
class MyRetrofitConfig : BaseRetrofitConfig() {

    override val baseUrl: String
        get() = API.BASE_URL

    override fun initOkHttpClient(): OkHttpClient {
        return BaseOkHttpClient.init()
    }
}