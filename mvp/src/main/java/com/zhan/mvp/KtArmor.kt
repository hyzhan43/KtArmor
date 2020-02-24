package com.zhan.mvp

import android.app.Application
import com.zhan.mvp.common.Preference
import com.zhan.mvp.ext.Toasts
import com.zhan.mvp.http.RetrofitConfig

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   KtArmor 框架初始化
 */

object KtArmor {

    lateinit var retrofit: RetrofitConfig

    fun init(context: Application, retrofit: RetrofitConfig) {

        this.retrofit = retrofit
        // 初始化 SharePreference
        Preference.init(context)

        Toasts.init(context)
    }
}
