package com.zhan.hy.ktarmor.account.presenter

import android.text.TextUtils
import android.util.Log
import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.mvp.http.KCallback
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view), LoginContract.Presenter {

    override fun login(account: String, password: String) {

        if (TextUtils.isEmpty(account)) {
            getView()?.accountEmpty(R.string.account_empty)
            return
        }

        if (TextUtils.isEmpty(password)) {
            getView()?.passwordEmpty(R.string.password_empty)
            return
        }

        LoginModel.login(account, password, {
            Log.d("LST", "loginRsp = $it")
        }, {

        })
    }
}