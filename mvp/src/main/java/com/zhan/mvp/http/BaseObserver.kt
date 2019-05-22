package com.zhan.mvp.http

import com.zhan.mvp.data.BaseResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
class BaseObserver<T : BaseResponse<*>>(private val sCallback: (T) -> Unit,
                                        private val fCallback: (String) -> Unit) : Observer<T> {

    override fun onNext(t: T) {
        t.data?.let { sCallback.invoke(t) } ?: fCallback.invoke(t.errorMsg)
    }

    override fun onError(e: Throwable) {
        fCallback.invoke(e.toString())
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onComplete() {
    }
}