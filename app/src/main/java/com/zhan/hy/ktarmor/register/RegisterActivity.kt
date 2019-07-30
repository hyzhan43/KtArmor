package com.zhan.hy.ktarmor.register

import com.zhan.mvp.mvp.MvpActivity
import com.zhan.hy.ktarmor.R

/**
 *  @author: hyzhan
 *  @date:   2019/07/30
 *  @desc:   TODO
 */

class RegisterActivity : MvpActivity<RegisterContract.Presenter>(), RegisterContract.View {

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun bindPresenter(): RegisterContract.Presenter = RegisterPresenter(this)
}