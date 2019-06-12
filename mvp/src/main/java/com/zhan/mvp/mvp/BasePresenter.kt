package com.zhan.mvp.mvp

import android.arch.lifecycle.LifecycleObserver
import android.support.annotation.StringRes
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class BasePresenter<V : BaseContract.View>(view: V) : BaseContract.Presenter, LifecycleObserver {

    val view: V?
        get() = mViewRef.get()

    // View 接口类型的弱引用
    private var mViewRef = WeakReference<V>(view)

    private val mCompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)

    private fun unSubscribe() = mCompositeDisposable.dispose()

    override fun detachView() {
        mViewRef.clear()
        unSubscribe()
    }
}