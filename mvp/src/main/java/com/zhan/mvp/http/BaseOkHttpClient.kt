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
 *  @desc:    封装基本 OkHttpClient, Log拦截器, 读写连接 时长
 */
object BaseOkHttpClient {

    // 初始化 okHttp
    fun init(vararg interceptors: Interceptor): OkHttpClient {

        return OkHttpClient.Builder().run {

            interceptors.forEach { addInterceptor(it) }

            addInterceptor(LoggingIntercept.init())
            readTimeout(Setting.READ_TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(Setting.WRITE_TIME_OUT, TimeUnit.SECONDS)
            connectTimeout(Setting.CONNECT_TIME_OUT, TimeUnit.SECONDS)

            build()
        }
    }
}