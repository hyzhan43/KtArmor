package com.zhan.mvp.mvp

import com.zhan.mvp.base.BaseActivity

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

    override fun showError(str: Int) {}

    override fun showError(str: String) {}

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}