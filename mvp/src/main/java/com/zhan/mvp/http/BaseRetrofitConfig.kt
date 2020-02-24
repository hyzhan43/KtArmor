package com.zhan.mvp.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
class BaseRetrofitConfig : RetrofitConfig {

    lateinit var baseUrl: String

    override fun initRetrofit(): Retrofit = BaseRetrofit.init(baseUrl)

    override fun initOkHttpClient(): OkHttpClient = BaseOkHttpClient.init()
}