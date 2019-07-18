package com.zhan.mvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   TODO
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 在界面未初始化之前调用的初始化窗口
        initWidows()

        if (initArgs(intent.extras)) {
            setContentView(getLayoutId())

            initBefore()
            initView()
            initListener()
            initData()
        } else {
            finish()
        }
    }

    open fun initArgs(bundle: Bundle?): Boolean = true

    open fun initWidows() {}

    abstract fun getLayoutId(): Int

    open fun initBefore() {}

    open fun initView() {}

    open fun initListener() {}

    open fun initData() {}
}