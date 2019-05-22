package com.zhan.mvp.mvp

import android.support.annotation.StringRes
import com.zhan.mvp.base.BaseActivity
import com.zhan.mvp.ext.Toasts.toast

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class MvpActivity<P : BaseContract.Presenter> : BaseActivity(), BaseContract.View {

    lateinit var mPresenter: P

    override fun initBefore() {
        super.initBefore()
        mPresenter = bindPresenter()
    }

    abstract fun bindPresenter(): P

    override fun showError(@StringRes str: Int) {
        toast(getString(str))
    }

    override fun showError(str: String) {
        toast(str)
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}