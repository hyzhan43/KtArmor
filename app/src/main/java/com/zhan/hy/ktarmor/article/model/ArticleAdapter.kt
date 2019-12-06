package com.zhan.hy.ktarmor.article.model

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhan.hy.ktarmor.R
import com.zhan.hy.ktarmor.article.model.data.ArticleData

/**
 *  @author: hyzhan
 *  @date:   2019/6/6
 *  @desc:   TODO
 */
class ArticleAdapter : BaseQuickAdapter<ArticleData, BaseViewHolder>(R.layout.article_item, null) {

    override fun convert(helper: BaseViewHolder?, item: ArticleData?) {
        helper?.setText(R.id.tvTitle, item?.title)
    }
}