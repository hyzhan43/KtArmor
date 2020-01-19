package com.zhan.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *  @author: hyzhan
 *  @date:   2019/6/5
 *  @desc:   测试中
 */
abstract class LazyFragment : BaseFragment() {

    private var rootView: View? = null
    private var isFirstLoad = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //视图创建完成，将变量置为true
        isFirstLoad = true

        //如果Fragment可见进行数据加载
        if (userVisibleHint) {
            onLazyLoad()
            isFirstLoad = false
        }

        return rootView ?: inflater.inflate(getLayoutId(), container, false).also { rootView = it }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        //视图变为可见并且是第一次加载
        if (isFirstLoad && isVisibleToUser) {
            onLazyLoad()
            isFirstLoad = false
        }
    }

    abstract fun onLazyLoad()

    override fun onDestroyView() {
        super.onDestroyView()
        //视图销毁将变量置为false
        isFirstLoad = false
    }
}