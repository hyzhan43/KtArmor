package com.zhan.mvp.mvp

import com.zhan.mvp.http.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
abstract class BaseModel<T> {

    val service by lazy { RetrofitFactory.newInstance.create(bindService()) }

    abstract fun bindService(): Class<T>

    suspend fun <R> launchIO(block: suspend CoroutineScope.() -> R) = withContext(Dispatchers.IO) {
        block()
    }
}