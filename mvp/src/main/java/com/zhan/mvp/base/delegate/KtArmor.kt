package com.zhan.mvp.base.delegate

import android.content.Context
import com.zhan.mvp.common.Preference

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */
class KtArmor private constructor(builder: Builder) {

    companion object {
        lateinit var BASE_URL: String
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    init {
        BASE_URL = builder.baseUrl
        // 初始化 SharePreference
        Preference.init(builder.context)
    }

    class Builder {
        lateinit var context: Context
        lateinit var baseUrl: String

        fun build() = KtArmor(this)
    }
}
