package com.zhan.hy.ktarmor.common

import com.zhan.hy.ktarmor.common.api.ApiService
import com.zhan.mvp.http.RetrofitFactory
import com.zhan.mvp.mvp.BaseContract
import com.zhan.mvp.mvp.BaseModel

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
abstract class ApiModel<P : BaseContract.Presenter>(model: P) : BaseModel<P>(model) {

    val apiService by lazy {
        RetrofitFactory.newInstance.create(ApiService::class.java)
    }
}