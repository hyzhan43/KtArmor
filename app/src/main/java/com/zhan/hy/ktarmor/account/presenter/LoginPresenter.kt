package com.zhan.hy.ktarmor.account.presenter

import android.text.TextUtils
import android.util.Log
import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginPresenter(view: LoginContract.View) :
        BasePresenter<LoginContract.View, LoginContract.Model>(view, LoginModel()),
        LoginContract.Presenter {


    override fun login(account: String, password: String) {

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            getView()?.showError(R.string.account_or_password_empty)
        } else {
            getModel()?.login(account, password) { str, a ->
                Log.d("LST", "it = $str")
            }
        }
    }
}