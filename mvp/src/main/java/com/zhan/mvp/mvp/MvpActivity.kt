package com.zhan.mvp.mvp

import com.zhan.mvp.base.BaseActivity

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class MvpActivity : BaseActivity(), BaseContract.View {

    lateinit var mPresenter: BaseContract.Presenter

    override fun initBefore() {
        super.initBefore()
        mPresenter = bindPresenter()
    }

    abstract fun bindPresenter(): BaseContract.Presenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}