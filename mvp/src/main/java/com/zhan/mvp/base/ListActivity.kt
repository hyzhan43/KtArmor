package com.zhan.mvp.base

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhan.mvp.R
import com.zhan.mvp.mvp.BaseContract
import com.zhan.mvp.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_list.*

/**
 *  @author: hyzhan
 *  @date:   2019/6/4
 *  @desc:   TODO
 */
abstract class ListActivity<P : BaseContract.Presenter, T> : MvpActivity<P>() {

    var refreshColor = R.color.refresh_color
        set(value) {
            field = refreshColor
            mSrlRefresh.setColorSchemeResources(value)
        }

    val dataList by lazy { ArrayList<T>() }

    val adapter by lazy { bindAdapter() }

    override fun getLayoutId(): Int = R.layout.activity_list

    override fun initView() {
        super.initView()

        // 初始化 SwipeRefreshLayout
        initRefresh()

        // 初始化 RecyclerView
        initRecyclerView()
    }

    private fun initRefresh() {
        // 设置 下拉刷新 loading 颜色
        mSrlRefresh.setColorSchemeResources(refreshColor)
        mSrlRefresh.setOnRefreshListener { onRefreshData() }
    }

    private fun initRecyclerView() {
        mRvContent.layoutManager = LinearLayoutManager(this)
        mRvContent.adapter = adapter

        adapter.setEnableLoadMore(true)
        // 上拉加载更多
        adapter.setOnLoadMoreListener({ onLoadMoreData() }, mRvContent)
    }

    fun addData(newDataList: List<T>) {

        // 如果为空的话，就直接 显示加载完毕
        if (newDataList.isEmpty()) {
            adapter.loadMoreEnd()
            return
        }

        // 如果是 下拉刷新 直接设置数据
        if (mSrlRefresh.isRefreshing) {
            mSrlRefresh.isRefreshing = false
            adapter.setNewData(newDataList)
            adapter.loadMoreComplete()
            return
        }

        // 否则 添加新数据
        adapter.addData(newDataList)
        adapter.loadMoreComplete()
    }

    /**
     *  绑定 adapter
     */
    abstract fun bindAdapter(): BaseQuickAdapter<T, BaseViewHolder>

    /**
     *  下拉刷新
     */
    abstract fun onRefreshData()

    /**
     *  上拉加载更多
     */
    abstract fun onLoadMoreData()
}