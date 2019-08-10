package com.zhan.mvp.http

import com.zhan.mvp.config.Setting
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
abstract class BaseRetrofitConfig : RetrofitConfig {

    override val readTimeOut: Long
        get() = Setting.READ_TIME_OUT

    override val writeTimeOut: Long
        get() = Setting.WRITE_TIME_OUT

    override val connectTimeOut: Long
        get() = Setting.CONNECT_TIME_OUT

    override fun initRetrofit(): Retrofit = BaseRetrofit.init()

    override fun initOkHttpClient(): OkHttpClient = BaseOkHttpClient.init()
}