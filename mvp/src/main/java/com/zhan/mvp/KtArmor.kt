package com.zhan.mvp

import android.app.Application
import android.content.Context
import com.zhan.mvp.common.Preference
import com.zhan.mvp.config.Setting
import com.zhan.mvp.ext.Toasts
import com.zhan.mvp.http.RetrofitConfig
import com.zhan.mvp.http.RetrofitFactory
import okhttp3.Interceptor

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */

object KtArmor {

    lateinit var retrofit: RetrofitConfig

    fun init(context: Application, retrofit: RetrofitConfig) {

        this.retrofit = retrofit
        // 初始化 SharePreference
        Preference.init(context)
    }
}
