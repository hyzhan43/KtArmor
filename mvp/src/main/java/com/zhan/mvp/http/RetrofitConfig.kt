package com.zhan.mvp.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
interface RetrofitConfig {

    fun initRetrofit(): Retrofit

    fun initOkHttpClient(): OkHttpClient
}