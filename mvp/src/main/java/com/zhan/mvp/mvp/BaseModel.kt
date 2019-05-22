package com.zhan.mvp.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference


/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
abstract class BaseModel<P : BaseContract.Presenter>(model: P) : BaseContract.Model {

    private val mCompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)

    private fun unSubscribe() = mCompositeDisposable.dispose()

    // View 接口类型的弱引用
    private var mPresenterRef = WeakReference<P>(model)

    fun getPresenter(): P? {
        return mPresenterRef.get()
    }

    override fun detachPresenter() {
        mPresenterRef.clear()
        unSubscribe()
    }
}