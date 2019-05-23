package com.zhan.mvp.http

import com.zhan.mvp.config.Setting
import com.zhan.mvp.data.BaseResponse
import com.zhan.mvp.ext.showLog
import com.zhan.mvp.mvp.BaseModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
class BaseObserver<T : BaseResponse<*>>(private val sCallback: (T) -> Unit,
                                        private val model: BaseModel<*>,
                                        private val fCallback: ((String) -> Unit)? = null) : Observer<T> {

    override fun onNext(response: T) {
        // 如果请求成功则 返回成功的 response
        if (response.errorCode == Setting.SUCCESS) {
            // 请求成功回调
            response.data?.let { sCallback.invoke(response) } ?: showError(response.errorMsg)
        } else {
            // 请求失败回调
            showError(response.errorMsg)
        }

        response.errorMsg.showLog()
    }

    override fun onError(e: Throwable) {
        // 输出日志
        e.toString().showLog()
        // 失败回调,
        showError(Setting.UNKNOWN_ERROR)
    }

    override fun onSubscribe(disposable: Disposable) {
        model.addSubscribe(disposable)
    }

    override fun onComplete() {}

    /**
     *  fCallback -> 不为空, 返回错误信息, 可以自定义处理逻辑
     *  否则调用 presenter 默认返回 显示 toast
     */
    private fun showError(message: String) {
        fCallback?.invoke(message) ?: model.getPresenter()?.showError(message)
    }
}