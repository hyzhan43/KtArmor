package com.zhan.hy.ktarmor.article.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhan.hy.ktarmor.article.model.ArticleAdapter
import com.zhan.hy.ktarmor.article.ArticleContract
import com.zhan.hy.ktarmor.article.model.data.ArticleData
import com.zhan.hy.ktarmor.article.presenter.ArticlePresenter
import com.zhan.mvp.base.ListActivity


/**
 *  @author: hyzhan
 *  @date:   2019/6/4
 *  @desc:   TODO
 */
class ArticleActivity : ListActivity<ArticleContract.Presenter, ArticleData>(), ArticleContract.View {

    override fun bindPresenter(): ArticleContract.Presenter = ArticlePresenter(this)

    override fun bindAdapter(): BaseQuickAdapter<ArticleData, BaseViewHolder> = ArticleAdapter()

    override fun initData() {
        super.initData()

        for (index in 1..10) {
            dataList.add(ArticleData("title = $index", "content = $index"))
        }

        addData(dataList)
    }

    override fun onRefreshData() {
        for (index in 1..10) {
            dataList.add(ArticleData("title = $index", "content = $index"))
        }

        addData(dataList)
    }

    override fun onLoadMoreData() {
        val newDataList = arrayListOf(ArticleData("new data", "new content"))
        addData(newDataList)
    }
}