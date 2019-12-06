package com.zhan.hy.ktarmor.common.api.test

import com.zhan.mvp.mvp.MvpActivity
import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.test.TestPresenter

/**
 *  @author: $author
 *  @date:   2019/07/30
 *  @desc:   TODO
 */

class TestActivity : MvpActivity<TestContract.Presenter>(), TestContract.View {

    override fun getLayoutId(): Int = R.layout.activity_test

    override fun bindPresenter(): TestContract.Presenter = TestPresenter(this)
}