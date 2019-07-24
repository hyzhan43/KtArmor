package com.zhan.mvp.mvp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
abstract class BaseModel {

    suspend fun <R> launchIO(block: suspend CoroutineScope.() -> R) = withContext(Dispatchers.IO) {
        block()
    }
}