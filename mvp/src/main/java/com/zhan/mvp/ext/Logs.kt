package com.zhan.mvp.ext

import android.content.Context
import android.util.Log

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   log 扩展函数
 */

fun Context.log(message: String) {
    Log.d(this.javaClass.name, message)
}