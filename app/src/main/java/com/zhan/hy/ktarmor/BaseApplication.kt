package com.zhan.hy.ktarmor

import android.app.Application
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
        KtArmor.init(this, RetrofitConfig())


    }
}