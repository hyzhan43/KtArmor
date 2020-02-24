package com.zhan.mvp

import android.app.Application
import com.zhan.mvp.common.Preference
import com.zhan.mvp.ext.Toasts
import com.zhan.mvp.http.BaseRetrofitConfig

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   KtArmor 框架初始化
 */

object KtArmor {

    var retrofitConfig = BaseRetrofitConfig()

    fun init(application: Application) {

        // 初始化 SharePreference
        Preference.init(application)
        Toasts.init(application)

        //application.registerActivityLifecycleCallbacks(ActivityLifecycle)
    }
}
