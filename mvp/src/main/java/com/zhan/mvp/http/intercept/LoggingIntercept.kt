package com.zhan.mvp.http.intercept

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   日志拦截器
 */
object LoggingIntercept {

    fun init(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}