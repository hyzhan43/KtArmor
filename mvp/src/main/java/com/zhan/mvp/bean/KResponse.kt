package com.zhan.mvp.bean

import com.zhan.mvp.config.Setting
import com.zhan.mvp.ext.Toasts

/**
 *  @author:  hyzhan
 *  @date:    2019/8/7
 *  @desc:    TODO
 */
interface KResponse<T> {

    fun isSuccess(): Boolean

    fun getKMessage(): String?

    fun getKData(): T?

    // 全局默认实现, 可根据自身业务 重写execute方法
    fun execute(success: ((T?) -> Unit)?, error: ((String) -> Unit)? = null) {
        if (this.isSuccess()) {
            success?.invoke(this.getKData())
            return
        }

        (this.getKMessage() ?: Setting.MESSAGE_EMPTY).let { error?.invoke(it) ?: Toasts.show(it) }
    }
}