package com.zhan.mvp.ext

import android.util.Log
import com.zhan.mvp.constant.Const

/**
 *  @author:  hyzhan
 *  @date:    2019/8/27
 *  @desc:    封装基本log
 */

fun logv(message: String, tag: String = Const.KT_ARMOR) = Log.v(tag, message)

fun logd(message: String, tag: String = Const.KT_ARMOR) = Log.d(tag, message)

fun logi(message: String, tag: String = Const.KT_ARMOR) = Log.i(tag, message)

fun logw(message: String, tag: String = Const.KT_ARMOR) = Log.w(tag, message)

fun loge(message: String, tag: String = Const.KT_ARMOR) = Log.e(tag, message)

fun String.showLog() {
    Log.d(Const.KT_ARMOR, "<-------------------KtArmor Start--------------------")
    Log.d(Const.KT_ARMOR, "[content]:  $this")
    Log.d(Const.KT_ARMOR, "--------------------KtArmor End------------------->")
}


