package com.zhan.mvp.ext

import android.app.Activity
import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   Toast 扩展函数
 */

object Toasts {

    private var mToast: Toast? = null

    /**
     *  如果 mToast 没有初始化, 就创建一个 Toast, 并赋值
     *  否则就直接显示
     */
    private fun <T : Context> showToast(context: T, message: String, duration: Int) {
        mToast?.let {
            it.duration = duration
            it.setText(message)
            it.show()
        } ?: Toast.makeText(context.applicationContext, message, duration).apply {
            mToast = this
            show()
        }
    }

    /**
     *  防止重复 showToast 显示
     *  如果 mToast不为空 就显示, 否则就创建新的 mToast
     */
    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        showToast(this, message, duration)
    }

    fun Context.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(message.toString(), duration)
    }

    fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        showToast(this, message, duration)
    }

    fun Activity.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(message.toString(), duration)
    }

    fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        context?.let { showToast(it, message, duration) }
    }

    fun Fragment.toast(@StringRes strRes: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(getString(strRes), duration)
    }
}
