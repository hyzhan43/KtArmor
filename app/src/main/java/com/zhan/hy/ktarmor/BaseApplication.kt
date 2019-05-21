package com.zhan.hy.ktarmor

import android.app.Application
import com.zhan.mvp.base.delegate.ApplicationDelegate

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   TODO
 */
class BaseApplication :Application(), ApplicationDelegate{

    override fun onCreate() {
        super.onCreate()

        initKtArmor(this)
    }
}