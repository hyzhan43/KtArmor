package com.zhan.hy.ktarmor.account.presenter

import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.common.bean.BaseResponse
import com.zhan.mvp.bean.KResponse
import com.zhan.mvp.ext.tryCatch
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view),
    LoginContract.Presenter {

    override fun login(account: String, password: String) {

        if (account.isEmpty()) {
            view?.accountEmpty(R.string.account_empty)
            return
        }

        if (password.isEmpty()) {
            view?.passwordEmpty(R.string.password_empty)
            return
        }


//        launchUI({
//            view?.showLoading()
//            LoginModel.login(account, password).Execute({ loginRsp ->
//                loginRsp?.let { view?.loginSuc(it) }
//            })
//        })

        quickLaunch<LoginRsp> {
            request { LoginModel.login(account, password) }

            onSuccess { loginRsp ->
                loginRsp?.let { view?.loginSuc(it) }
            }
        }
    }
}