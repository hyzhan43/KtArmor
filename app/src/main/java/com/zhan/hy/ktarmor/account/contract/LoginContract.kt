package com.zhan.hy.ktarmor.account.contract

import com.zhan.mvp.mvp.BaseContract

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
interface LoginContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter {
        fun login(account: String, password: String)
    }

    interface Model : BaseContract.Model {
        fun login(account: String, password: String, callback: (String, Boolean) -> Unit)
    }
}