package com.zhan.mvp.ext

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   TODO
 */

// 统一处理  (IO -> Main)
fun <T> Observable<T>.execute(
    onSuccess: (T) -> Unit,
    onFail: ((String) -> Unit)? = null
): Disposable {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onSuccess, {
            onFail?.invoke(it.toString())
            it.toString().showLog()
        })
}

// 统一处理  (IO -> Main)
fun <T> Observable<T>.execute(observer: Observer<T>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
}

// IO -> Main
fun <T> Observable<T>.ioToMain(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}