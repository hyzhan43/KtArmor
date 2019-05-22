package com.zhan.hy.ktarmor.account.contract

import com.zhan.mvp.mvp.BaseContract

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
interface LoginContract {

    interface View : BaseContract.View {
        fun accountEmpty(msg: Int)
        fun passwordEmpty(msg: Int)
    }

    interface Presenter : BaseContract.Presenter {
        fun login(account: String, password: String)
    }
}