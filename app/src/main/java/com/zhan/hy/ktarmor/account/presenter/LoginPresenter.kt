package com.zhan.hy.ktarmor.account.presenter

import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.LoginModel
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.common.bean.BaseResponse
import com.zhan.mvp.bean.KResponse
import com.zhan.mvp.ext.tryCatch
import com.zhan.mvp.mvp.BasePresenter
import kotlinx.coroutines.launch

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

        /**
         *  原始请求
         */
        /*presenterScope.launch {
            tryCatch({
                view?.showLoading()
                val response = LoginModel.login(account, password)

                if (response.isSuccess()) {
                    response.data?.let { view?.loginSuc(it) }
                } else {
                    view?.loginFail(response.errorMsg)
                }
            }, {
                view?.loginError(it.toString())
            })
        }*/


        /**
         *  封装的扩展方法
         */
        /*launchUI({
            view?.showLoading()
            LoginModel.login(account, password).execute({ loginRsp ->
                loginRsp?.let { view?.loginSuc(it) }
            })
        })*/

        /**
         *  DSL 方式
         */
        quickLaunch<LoginRsp> {
            request { LoginModel.login(account, password) }

            onSuccess { loginRsp ->
                loginRsp?.let { view?.loginSuc(it) }
            }

            onFail { message ->
                message?.let { view?.loginFail(it) }
            }

            onException { throwable ->
                throwable?.let { view?.loginError(it.toString()) }
            }
        }
    }
}