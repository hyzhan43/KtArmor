package com.zhan.hy.ktarmor.article.presenter

import com.zhan.hy.ktarmor.article.ArticleContract
import com.zhan.hy.ktarmor.article.model.ArticleModel
import com.zhan.mvp.mvp.BasePresenter

/**
 *  @author: hyzhan
 *  @date:   2019/6/6
 *  @desc:   TODO
 */
class ArticlePresenter(view: ArticleContract.View) : BasePresenter<ArticleContract.View, ArticleContract.Model>(view),
        ArticleContract.Presenter {

    override fun bindModel(): ArticleContract.Model = ArticleModel(this)
}