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
abstract class ListActivity<P : BaseContract.Presenter, T, A : BaseQuickAdapter<T, *>> : MvpActivity<P>() {

    // 当前页
    var page = 0
    /**
     * 总数据
     * 一定要设置！！！不然无法显示数据
     * 一般在搜索结果返回后设置
     */
    var total = 0

    var refreshColor = R.color.refresh_color

    val adapter by lazy { bindAdapter() }

    override fun getLayoutId(): Int = R.layout.activity_list

    override fun initView() {
        super.initView()

        // 初始化 SwipeRefreshLayout
        initRefresh()

        // 初始化 article
        initRecyclerView()
    }

    override fun initData() {
        super.initData()

        onRefreshData()
    }

    private fun initRefresh() {
        // 设置 下拉刷新 loading 颜色
        srlRefresh.setColorSchemeResources(refreshColor)
        srlRefresh.setOnRefreshListener {
            page = 0
            onRefreshData()
        }
    }

    private fun initRecyclerView() {

        rvContent.layoutManager = LinearLayoutManager(this)
        rvContent.adapter = adapter

        // 上拉加载更多
        adapter.setOnLoadMoreListener({
            ++page
            onLoadMoreData()
        }, rvContent)
    }

    abstract fun bindAdapter(): A
    /**
     *  下拉刷新
     */
    abstract fun onRefreshData()

    /**
     *  上拉加载更多
     */
    abstract fun onLoadMoreData()

    // 判断是否有更多数据
    fun hasMore() = adapter.data.size < this.total

    fun addData(newData: List<T>) {
        if (srlRefresh.isRefreshing) {
            srlRefresh.isRefreshing = false
            adapter.setNewData(newData)
            return
        }

        adapter.addData(newData)

        if (!hasMore()) {
            adapter.loadMoreEnd()
        } else {
            adapter.loadMoreComplete()
        }
    }

    fun setMoreData(newData: List<T>) {
        adapter.addData(newData)

        if (!hasMore()) {
            adapter.loadMoreEnd()
        } else {
            adapter.loadMoreComplete()
        }
    }

    fun setNewData(newData: List<T>) {
        if (srlRefresh.isRefreshing) {
            srlRefresh.isRefreshing = false
            adapter.run {
                setNewData(newData)
                loadMoreComplete()
            }
        }
    }
}
