package com.zhan.hy.ktarmor.common

import com.zhan.hy.ktarmor.common.api.ApiService
import com.zhan.mvp.mvp.BaseModel

/**
 *  @author:  hyzhan
 *  @date:    2019/7/5
 *  @desc:    TODO
 */
open class ApiModel: BaseModel<ApiService>() {

    override fun bindService(): Class<ApiService> = ApiService::class.java
    
}