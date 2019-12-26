package com.zhan.hy.ktarmor.account.ui

import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.account.presenter.LoginPresenter
import com.zhan.mvp.delegate.Intent
import com.zhan.mvp.ext.Toasts.toast
import com.zhan.mvp.ext.str
import com.zhan.mvp.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginActivity : MvpActivity<LoginContract.Presenter>(), LoginContract.View {

    private var tip by Intent("hello", "!!!!")

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun bindPresenter(): LoginContract.Presenter = LoginPresenter(this)

    override fun initListener() {
        super.initListener()

        toast(tip)

        mBtnLogin.setOnClickListener {
            mTilAccount.isErrorEnabled = false
            mTilPassword.isErrorEnabled = false
            presenter.login(mEtAccount.str(), mEtPassword.str())
        }
    }

    override fun accountEmpty(msg: Int) {
        mTilAccount.isErrorEnabled = true
        mTilAccount.requestFocus()
        mTilAccount.error = getString(msg)
    }

    override fun passwordEmpty(msg: Int) {
        mTilPassword.isErrorEnabled = true
        mTilPassword.requestFocus()
        mTilPassword.error = getString(msg)
    }

    override fun loginSuc(loginRsp: LoginRsp) {
        toast("登陆成功！")
        hideLoading()
    }

    override fun loginError(toString: String) {

    }

    override fun loginFail(errorMsg: String) {

    }
}