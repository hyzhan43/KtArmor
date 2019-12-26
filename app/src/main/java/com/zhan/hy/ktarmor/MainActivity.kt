package com.zhan.hy.ktarmor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zhan.hy.ktarmor.account.ui.LoginActivity
import com.zhan.hy.ktarmor.article.ui.ArticleActivity
import com.zhan.mvp.ext.startActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            startActivity<LoginActivity>()
        }

        btnArticle.setOnClickListener {
            startActivity<ArticleActivity>("abc" to "看的见我吗", "bcd" to "看不见")
        }

        mLoading.setOnClickListener {
            mLoading.start()
        }

        emptyView.setOnClickListener {
            emptyView.triggerNetError("Hello World")
        }
    }
}
