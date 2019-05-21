package com.zhan.mvp.mvp

import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class BasePresenter<V : BaseContract.View, M : BaseContract.Model>(view: V, model: M) : BaseContract.Presenter {

    // View 接口类型的弱引用
    private var mViewRef = WeakReference<V>(view)

    private var mModelRef =  WeakReference<M>(model)

    fun getView(): V? {
        return mViewRef.get()
    }

    fun getModel(): M? {
        return mModelRef.get()
    }

    override fun detachView() {
        mViewRef.clear()
    }

    override fun detachModel() {
        mModelRef.clear()
    }
}