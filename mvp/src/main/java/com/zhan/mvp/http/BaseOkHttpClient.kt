package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import com.zhan.mvp.config.Setting
import com.zhan.mvp.http.intercept.LoggingIntercept
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
object BaseOkHttpClient {

    // 初始化 okHttp
    fun init(vararg interceptors: Interceptor): OkHttpClient {

        return OkHttpClient.Builder().run {

            interceptors.forEach { addInterceptor(it) }

            addInterceptor(LoggingIntercept.init())
            readTimeout(KtArmor.retrofit.readTimeOut, TimeUnit.SECONDS)
            writeTimeout(KtArmor.retrofit.writeTimeOut, TimeUnit.SECONDS)
            connectTimeout(KtArmor.retrofit.connectTimeOut, TimeUnit.SECONDS)

            build()
        }
    }
}