package com.zhan.mvp.http.rx

import com.zhan.mvp.config.Setting
import com.zhan.mvp.data.BaseResponse
import com.zhan.mvp.ext.showLog
import com.zhan.mvp.mvp.BasePresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  @author: hyzhan
 *  @date:   2019/6/12
 *  @desc:   TODO
 */
class BaseObserver<R, T : BaseResponse<R>>(val presenter: BasePresenter<*>,
                                           private val onSuccess: (R) -> Unit,
                                           private val onFail: ((String) -> Unit)? = null) : Observer<T> {

    override fun onNext(response: T) {
        // 如果请求成功则 返回成功的 response
        if (response.errorCode == Setting.SUCCESS) {
            // 请求成功回调
            response.data?.let { onSuccess.invoke(it) } ?: showError(response.errorMsg)
            return
        }

        // 请求失败回调
        showError(response.errorMsg)
        response.errorMsg.showLog()
    }

    override fun onError(e: Throwable) {
        // 输出日志
        e.toString().showLog()
        // 失败回调,
        showError(Setting.UNKNOWN_ERROR)
    }

    override fun onSubscribe(disposable: Disposable) {
        presenter.addSubscribe(disposable)
    }

    override fun onComplete() {}

    /**
     *  如果onFail 不为null, 则回调 onFail
     *  默认回调 view.showError() 也就是 Toast
     */
    private fun showError(message: String) {
        onFail?.invoke(message) ?: presenter.view?.showError(message)
    }
}