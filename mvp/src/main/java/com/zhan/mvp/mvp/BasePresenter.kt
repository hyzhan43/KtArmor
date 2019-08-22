package com.zhan.mvp.mvp

import android.support.annotation.StringRes
import com.zhan.mvp.bean.KResponse
import com.zhan.mvp.config.Setting
import com.zhan.mvp.ext.tryCatch
import kotlinx.coroutines.*
import java.lang.ref.WeakReference

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class BasePresenter<V : BaseContract.View>(view: V) : BaseContract.Presenter{

    val view: V?
        get() = mViewRef.get()

    // View 接口类型的弱引用
    private var mViewRef = WeakReference(view)

    val presenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    fun launchUI(block: suspend CoroutineScope.() -> Unit, error: ((Throwable) -> Unit)? = null) {
        presenterScope.launch {
            tryCatch({
                block()
            }, {
                error?.invoke(it) ?: view?.showError(it.toString())
            })
        }
    }

    fun <R> KResponse<R>.execute(success: (R?) -> Unit, error: ((String) -> Unit)? = null) {
        if (this.isSuccess()) {
            success(this.getKData())
        } else {
            (this.getKMessage() ?: Setting.MESSAGE_EMPTY).let {
                error?.invoke(it) ?: showError(it)
            }
        }
    }

    override fun showError(msg: String) {
        view?.showError(msg)
    }

    override fun showError(@StringRes strRes: Int) {
        view?.showError(strRes)
    }

    override fun showLoading() {
        view?.showLoading()
    }

    override fun detachView() {
        mViewRef.clear()
        // 取消掉 presenterScope创建的所有协程和其子协程。
        presenterScope.cancel()
    }
}