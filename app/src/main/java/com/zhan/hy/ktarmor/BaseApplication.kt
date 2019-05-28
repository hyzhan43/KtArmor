package com.zhan.hy.ktarmor

import android.app.Application
import com.zhan.hy.ktarmor.common.api.API
import com.zhan.mvp.KtArmor

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   TODO
 */
class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        // 初始化KtArmor
        KtArmor.build {
            context = applicationContext
            baseUrl = API.BASE_URL

//             选择配置
//            readTime = 20L
//            writeTime = 30L
//            connectTime = 5L
        }
    }
}