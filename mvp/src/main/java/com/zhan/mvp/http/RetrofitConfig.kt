package com.zhan.mvp.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
interface RetrofitConfig {

    val baseUrl: String

    val readTimeOut: Long
    val writeTimeOut: Long
    val connectTimeOut: Long

    fun initRetrofit(): Retrofit

    fun initOkHttpClient(): OkHttpClient
}