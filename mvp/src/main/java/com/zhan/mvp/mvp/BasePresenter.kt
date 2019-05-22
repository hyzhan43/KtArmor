package com.zhan.mvp.mvp

import android.support.annotation.StringRes
import java.lang.ref.WeakReference

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class BasePresenter<V : BaseContract.View, M : BaseContract.Model>(view: V) : BaseContract.Presenter {

    // View 接口类型的弱引用
    private var mViewRef = WeakReference<V>(view)

    val mModel: M by lazy { bindModel() }

    fun getView(): V? {
        return mViewRef.get()
    }

    abstract fun bindModel(): M

    override fun showError(@StringRes res: Int) {
        getView()?.showError(res)
    }

    override fun showError(message: String) {
        getView()?.showError(message)
    }

    override fun detachView() {
        mViewRef.clear()
        mModel.detachPresenter()
    }
}