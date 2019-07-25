package com.zhan.mvp.base

import android.content.res.Resources
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.zhan.mvp.R

/**
 *  @author:  hyzhan
 *  @date:    2019/7/23
 *  @desc:    需要为 Toolbar 控件设置id 为 toolbar
 */
abstract class ToolbarActivity : BaseActivity() {

    var toolbarTitle: String = ""
        set(value) {
            field = value
            supportActionBar?.title = value
        }

    override fun initView() {
        super.initView()
        initToolbar()
    }

    private fun initToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            setSupportActionBar(toolbar)
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setDisplayShowHomeEnabled(true)
            }
        }
        // ?: throw Resources.NotFoundException("Toolbar id must be toolbar")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            //将滑动菜单显示出来
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}