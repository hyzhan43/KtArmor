package com.zhan.mvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *  @author: hyzhan
 *  @date:   2019/5/16
 *  @desc:   基本 Fragment 封装
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBefore()
        initView()
        initListener()
        initData()
    }

    open fun initBefore() {}

    open fun initView() {}

    open fun initListener() {}

    open fun initData() {}
}