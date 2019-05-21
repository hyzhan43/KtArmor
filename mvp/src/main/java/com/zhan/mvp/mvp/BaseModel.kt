package com.zhan.mvp.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
abstract class BaseModel: BaseContract.Model {

    private val mCompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)

    fun unSubscribe() = mCompositeDisposable.dispose()
}