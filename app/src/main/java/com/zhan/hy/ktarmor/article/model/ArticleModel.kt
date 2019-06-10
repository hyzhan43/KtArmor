package com.zhan.hy.ktarmor.article.model

import com.zhan.hy.ktarmor.article.ArticleContract
import com.zhan.hy.ktarmor.common.ApiModel

/**
 *  @author: hyzhan
 *  @date:   2019/6/6
 *  @desc:   TODO
 */
class ArticleModel<T : ArticleContract.Presenter>(presenter: T) : ApiModel<T>(presenter), ArticleContract.Model {

}