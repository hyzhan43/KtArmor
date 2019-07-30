package com.zhan.hy.ktarmor.test

import com.zhan.hy.ktarmor.common.api.test.TestContract
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: $author
 *  @date:   2019/07/30
 *  @desc:   TODO
 */

class TestPresenter(view: TestContract.View) : BasePresenter<TestContract.View>(view), TestContract.Presenter {

}