package com.zhan.hy.ktarmor.account.presenter

import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.mvp.ext.execute
import com.zhan.mvp.http.rx.BaseObserver
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view), LoginContract.Presenter {

    override fun login(account: String, password: String) {

        if (account.isEmpty()) {
            view?.accountEmpty(R.string.account_empty)
            return
        }

        if (password.isEmpty()) {
            view?.passwordEmpty(R.string.password_empty)
            return
        }

        view?.showLoading()
        LoginModel.login(account, password).execute(BaseObserver(this, {
            view?.loginSuc(it)
        }))
    }
}