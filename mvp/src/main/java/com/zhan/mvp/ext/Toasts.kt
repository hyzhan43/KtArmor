package com.zhan.mvp.ext

import android.content.Context
import android.support.annotation.StringRes
import android.view.View
import android.widget.Toast

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   Toast 扩展函数
 */

object Toasts {

    private var mToast: Toast? = null

    /**
     *  防止重复 toast 显示
     *  如果 mToast不为空 就显示, 否则就创建新的 mToast
     */
    fun Context.toast(message: String) {
        mToast?.run {
            duration = Toast.LENGTH_SHORT
            setText(message)
            show()
        } ?: Toast.makeText(this, message, Toast.LENGTH_SHORT).apply {
            mToast = this
            show()
        }
    }

    fun Context.toast(message: Int) {
        toast(message.toString())
    }

    fun View.toast(message: String) {
        mToast?.run {
            duration = Toast.LENGTH_SHORT
            setText(message)
            show()
        } ?: Toast.makeText(context, message, Toast.LENGTH_SHORT).apply {
            mToast = this
            show()
        }
    }

    fun View.toast(@StringRes strRes: Int) {
        toast(context.getString(strRes))
    }
}
