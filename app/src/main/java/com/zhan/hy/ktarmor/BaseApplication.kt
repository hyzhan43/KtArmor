package com.zhan.hy.ktarmor

import android.app.Application
import com.zhan.hy.ktarmor.common.api.API
import com.zhan.mvp.base.delegate.ApplicationDelegate
import com.zhan.mvp.base.delegate.KtArmor

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   TODO
 */
class BaseApplication : Application(), ApplicationDelegate {

    override fun onCreate() {
        super.onCreate()

        // 初始化KtArmor
        KtArmor.build {
            context = applicationContext
            baseUrl = API.BASE_URL
        }
    }
}