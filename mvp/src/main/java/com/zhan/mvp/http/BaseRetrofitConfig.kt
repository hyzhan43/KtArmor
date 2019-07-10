package com.zhan.mvp.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
abstract class BaseRetrofitConfig : RetrofitConfig {

    override fun initRetrofit(): Retrofit = BaseRetrofit.init()

    override fun initOkHttpClient(): OkHttpClient = BaseOkHttpClient.init()
}