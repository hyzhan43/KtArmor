package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import retrofit2.Retrofit

/**
 *  @author: hyzhan
 *  @date:   2019/5/17
 *  @desc:   TODO
 */
class RetrofitFactory private constructor() {

    companion object {
        val instance by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit by lazy {
        KtArmor.retrofit.initRetrofit()
    }

    fun <T> create(clz: Class<T>): T {
        return retrofit.create(clz)
    }
}