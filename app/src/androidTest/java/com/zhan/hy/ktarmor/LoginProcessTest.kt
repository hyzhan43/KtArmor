package com.zhan.hy.ktarmor

import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.IdlingResource
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.zhan.hy.ktarmor.BaseTest.onClick
import com.zhan.hy.ktarmor.BaseTest.onEditView
import com.zhan.hy.ktarmor.BaseTest.onToast
import com.zhan.hy.ktarmor.account.ui.LoginActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  author:  hyzhan
 *  date:    2020/2/24
 *  desc:    TODO
 */
@RunWith(AndroidJUnit4::class)
class LoginProcessTest {

    private val account: String = "1142948328"
    private val password: String = "123456"

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(LoginActivity::class.java)

    private lateinit var idlingResource: IdlingResource

    @Before
    fun setUp() {
        idlingResource = activityTestRule.activity.mIdlingResource
    }

    @After
    fun release() {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }

    @Test
    fun test_error_account_or_password() {
        onEditView(R.id.mTieAccount, account)
        onEditView(R.id.mTiePassword, "123")

        IdlingRegistry.getInstance().register(idlingResource)
        onClick(R.id.mBtnLogin)
        onToast(activityTestRule.activity, "账号密码不匹配！")
    }

    @Test
    fun test_login_success_by_myself() {
        onEditView(R.id.mTieAccount, account)
        onEditView(R.id.mTiePassword, password)

        IdlingRegistry.getInstance().register(idlingResource)
        onClick(R.id.mBtnLogin)
        onToast(activityTestRule.activity, activityTestRule.activity.getString(R.string.login_success))
    }
}