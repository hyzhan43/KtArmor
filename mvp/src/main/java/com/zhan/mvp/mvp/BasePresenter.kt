package com.zhan.mvp.mvp

import android.arch.lifecycle.LifecycleObserver
import kotlinx.coroutines.*
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
    private var mViewRef = WeakReference(view)

    private val presenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    fun launchUI(block: suspend CoroutineScope.() -> Unit) {
        presenterScope.launch { block() }
    }

    override fun detachView() {
        mViewRef.clear()
        // 取消掉 presenterScope创建的所有协程和其子协程。
        presenterScope.cancel()
    }
}