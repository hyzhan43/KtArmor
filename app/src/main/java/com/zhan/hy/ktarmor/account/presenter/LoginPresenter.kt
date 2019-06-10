package com.zhan.hy.ktarmor.account.presenter

import android.text.TextUtils
import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.mvp.ext.showLog
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View, LoginContract.Model>(view),
        LoginContract.Presenter {

    override fun bindModel(): LoginContract.Model = LoginModel(this)

    override fun login(account: String, password: String) {

        if (TextUtils.isEmpty(account)) {
            getView()?.accountEmpty(R.string.account_empty)
            return
        }

        if (TextUtils.isEmpty(password)) {
            getView()?.passwordEmpty(R.string.password_empty)
            return
        }

        getView()?.showLoading()
        mModel.login(account, password) {
            it.errorMsg.showLog()
        }

        // 第二种方式
//        mModel.login(account, password, {
//            // TODO service
//        },{
//            // TODO error
//        })
    }
}