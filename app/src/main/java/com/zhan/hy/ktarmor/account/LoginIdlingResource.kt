package com.zhan.hy.ktarmor.account

import android.support.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean

/**
 *  author:  hyzhan
 *  date:    2020/2/24
 *  desc:    TODO
 */
class LoginIdlingResource : IdlingResource {

    var callback: IdlingResource.ResourceCallback? = null

    private val mIsIdleNow = AtomicBoolean(true)

    override fun getName(): String = this.javaClass.name

    override fun isIdleNow(): Boolean = mIsIdleNow.get()

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback
    }

    fun setIdleState(isIdleNow: Boolean) {
        mIsIdleNow.set(isIdleNow)
        if (isIdleNow) {
            callback?.onTransitionToIdle()
        }
    }

    fun isIdleState(){
        setIdleState(true)
    }

    fun isNotIdleState(){
        setIdleState(false)
    }
}