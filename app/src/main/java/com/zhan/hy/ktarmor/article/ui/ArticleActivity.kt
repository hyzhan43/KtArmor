package com.zhan.hy.ktarmor.article.ui

import android.os.Bundle
import com.zhan.hy.ktarmor.article.ArticleContract
import com.zhan.hy.ktarmor.article.model.ArticleAdapter
import com.zhan.hy.ktarmor.article.model.data.ArticleData
import com.zhan.hy.ktarmor.article.presenter.ArticlePresenter
import com.zhan.mvp.base.ListActivity
import com.zhan.mvp.ext.showLog


/**
 *  @author: hyzhan
 *  @date:   2019/6/4
 *  @desc:   TODO
 */
class ArticleActivity : ListActivity<ArticleContract.Presenter, ArticleData>(), ArticleContract.View {

    override fun bindPresenter(): ArticleContract.Presenter = ArticlePresenter(this)

    override fun bindAdapter() = ArticleAdapter()

    override fun initArgs(bundle: Bundle?): Boolean {

        bundle?.let {
            it.getString("abc")?.showLog()
            it.getString("bcd")?.showLog()
        }

        return super.initArgs(bundle)
    }

    override fun onRefreshData() {
        val test = arrayListOf<ArticleData>()
        for (i in 1..10) {
            test.add(ArticleData("title = $i", "content = $i"))
        }
        addData(test)
    }

    override fun onLoadMoreData() {
        val test = arrayListOf<ArticleData>()
        test.add(ArticleData("new title1", "new content1"))
        test.add(ArticleData("new title2", "new content2"))
        test.add(ArticleData("new title3", "new content3"))
        addData(test)
    }
}