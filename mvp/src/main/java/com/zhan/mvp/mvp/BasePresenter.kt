package com.zhan.mvp.mvp

import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
class BasePresenter<V : BaseContract.View>(view: V) : BaseContract.Presenter {

    init {
        attachView(view)
    }

    // View 接口类型的弱引用
    private lateinit var mViewRef: Reference<V>

    protected fun isViewAttach(): Boolean {
        return mViewRef.get() != null
    }

    private fun attachView(view: V) {
        mViewRef = WeakReference<V>(view)
    }

    override fun detachView() {
        mViewRef.clear()
    }
}