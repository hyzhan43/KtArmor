package com.zhan.hy.ktarmor

import com.zhan.hy.ktarmor.common.api.API
import com.zhan.mvp.http.BaseRetrofitConfig

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
class MyRetrofitConfig : BaseRetrofitConfig() {

    override val baseUrl: String
        get() = API.BASE_URL

}