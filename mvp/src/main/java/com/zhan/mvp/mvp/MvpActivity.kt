package com.zhan.mvp.mvp

import android.support.annotation.StringRes
import com.zhan.mvp.base.BaseActivity
import com.zhan.mvp.base.ToolbarActivity
import com.zhan.mvp.ext.Toasts.toast

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class MvpActivity<P : BaseContract.Presenter> : ToolbarActivity(), BaseContract.View {

    lateinit var presenter: P

    override fun initBefore() {
        presenter = bindPresenter()
    }

    abstract fun bindPresenter(): P

    override fun showError(@StringRes msgRes: Int) {
        showError(getString(msgRes))
    }

    override fun showError(msg: String) {
        toast(msg)
        hideLoading()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        super.onDestroy()

        if (::presenter.isInitialized) {
            presenter.detachView()
        }
    }
}