package com.zhan.mvp.http

import com.zhan.mvp.R
import com.zhan.mvp.config.Setting
import com.zhan.mvp.data.BaseResponse
import com.zhan.mvp.mvp.BaseModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
class BaseObserver<T : BaseResponse<*>>(private val sCallback: (T) -> Unit,
                                        private val model: BaseModel<*>) : Observer<T> {

    override fun onNext(t: T) {
        if (t.errorCode == Setting.SUCCESS) {
            t.data?.let { sCallback.invoke(t) }
                    ?: model.getPresenter()?.showError(R.string.unknown_error)
        } else {
            model.getPresenter()?.showError(t.errorMsg)
        }
    }

    override fun onError(e: Throwable) {
        // TODO print log
    }

    override fun onSubscribe(disposable: Disposable) {
        model.addSubscribe(disposable)
    }

    override fun onComplete() {
    }
}