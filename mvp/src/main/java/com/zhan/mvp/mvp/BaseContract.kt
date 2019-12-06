package com.zhan.mvp.mvp

import android.support.annotation.StringRes

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   基本契约类
 */

interface BaseContract {

    interface View {
        fun showError(@StringRes msgRes: Int)

        fun showError(msg: String)

        fun showLoading()

        fun hideLoading()
    }

    interface Presenter {
        fun showError(msg: String)

        fun showError(@StringRes strRes: Int)

        fun showLoading()

        fun detachView()
    }
}