package com.zhan.mvp.mvp

import android.content.Context
import android.support.annotation.StringRes
import com.zhan.mvp.base.BaseFragment
import com.zhan.mvp.ext.Toasts.toast

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class MvpFragment<P : BaseContract.Presenter>: BaseFragment(), BaseContract.View {

    lateinit var mPresenter: P

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter = bindPresenter()
    }

    abstract fun bindPresenter(): P

    override fun showError(@StringRes msgRes: Int) {
        showError(getString(msgRes))
    }

    override fun showError(msg: String) {
        context?.toast(msg)
        hideLoading()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}