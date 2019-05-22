package com.zhan.mvp.mvp

import android.support.annotation.StringRes

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   基本契约类
 */

interface BaseContract {

    interface View {
        fun showError(@StringRes str: Int)

        fun showError(str: String)

        fun showLoading()

        fun hideLoading()
    }

    interface Presenter {
        fun detachView()
    }

    interface Model {
    }
}