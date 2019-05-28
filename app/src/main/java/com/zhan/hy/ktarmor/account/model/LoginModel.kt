package com.zhan.hy.ktarmor.account.model

import com.zhan.hy.ktarmor.account.contract.LoginContract
import com.zhan.hy.ktarmor.account.model.response.LoginRsp
import com.zhan.hy.ktarmor.common.ApiModel
import com.zhan.mvp.data.BaseResponse
import com.zhan.mvp.ext.execute
import com.zhan.mvp.http.rx.BaseObserver

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class LoginModel<T : LoginContract.Presenter>(presenter: T) : ApiModel<T>(presenter), LoginContract.Model {

    override fun login(account: String, password: String, sCallback: (BaseResponse<LoginRsp>) -> Unit) {
        apiService.login(account, password)
                .execute(BaseObserver(sCallback, this))
    }

    override fun login(account: String, password: String, sCallback: (BaseResponse<LoginRsp>) -> Unit,
                       fCallback: (String) -> Unit) {

        apiService.login(account, password)
                .execute(BaseObserver(sCallback, this, fCallback))
    }
}