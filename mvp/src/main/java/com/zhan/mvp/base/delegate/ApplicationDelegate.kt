package com.zhan.mvp.base.delegate

import android.content.Context
import com.zhan.mvp.common.Preference

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   application 代理类, 主要初始化 KtArmor
 */
interface ApplicationDelegate {

    fun initKtArmor(context: Context) {

        // 初始化 SharePreference
        Preference.init(context)
    }
}