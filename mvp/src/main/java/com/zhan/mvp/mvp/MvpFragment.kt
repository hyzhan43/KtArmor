package com.zhan.mvp.mvp

import android.content.Context
import com.zhan.mvp.base.BaseFragment

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class MvpFragment: BaseFragment(), BaseContract.View {

    lateinit var mPresenter: BaseContract.Presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter = bindPresenter()
    }

    abstract fun bindPresenter(): BaseContract.Presenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}