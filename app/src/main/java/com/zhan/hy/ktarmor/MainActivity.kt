package com.zhan.hy.ktarmor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zhan.hy.ktarmor.account.ui.LoginActivity
import com.zhan.mvp.ext.startActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLogin.setOnClickListener {
            startActivity<LoginActivity>()
        }
    }
}
