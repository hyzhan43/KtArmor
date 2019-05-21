package com.zhan.mvp.ext

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
inline fun <reified T: Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    this.startActivity(intent)
}
