package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import com.zhan.mvp.anotation.BaseUrl

/**
 *  @author: hyzhan
 *  @date:   2019/5/17
 *  @desc:   TODO
 */
object RetrofitFactory {

    fun <T> create(clz: Class<T>): T {
        prepareBaseUrl(clz)

        val retrofit = KtArmor.retrofitConfig.initRetrofit()

        return retrofit.create(clz)
    }

    private fun <T> prepareBaseUrl(clz: Class<T>) {
        val baseUrlAnnotation = clz.getAnnotation(BaseUrl::class.java)
        val baseUrl = baseUrlAnnotation?.value ?: throw IllegalArgumentException("base url is null")
        KtArmor.retrofitConfig.baseUrl = baseUrl
    }
}