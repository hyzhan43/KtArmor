package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import com.zhan.mvp.http.intercept.LoggingIntercept
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  @author: hyzhan
 *  @date:   2019/5/17
 *  @desc:   TODO
 */
class RetrofitFactory private constructor() {

    companion object {
        val newInstance by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(KtArmor.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initOkHttpClient())
                .build()
    }

    // 初始化 okHttp
    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(LoggingIntercept.init())
                .readTimeout(KtArmor.READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(KtArmor.WRITE_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(KtArmor.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build()
    }

    fun <T> create(clz: Class<T>): T {
        return retrofit.create(clz)
    }
}