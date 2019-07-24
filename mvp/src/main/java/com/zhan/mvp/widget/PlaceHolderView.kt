package com.zhan.mvp.widget

import android.content.Context
import android.graphics.Color
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.zhan.mvp.R
import com.zhan.mvp.ext.Toasts.toast
import kotlinx.android.synthetic.main.layout_empty.view.*

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
class PlaceHolderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    LinearLayout(context, attrs, defStyle) {

    private val defaultDrawable = R.drawable.ic_empty_view
    private val defaultColor = Color.GRAY

    var emptyDrawable: Int = 0
    var errorDrawable: Int = 0

    var loadingColor = 0
        set(color) {
            field = color
            loading.innerColor = color
            loading.outerColor = color
        }

    var emptyText: String? = null
        set(value) {
            field = value ?: context.getString(R.string.prompt_empty)
        }

    var errorText: String? = null
        set(value) {
            field = value ?: context.getString(R.string.prompt_error)
        }

    var loadingText: String? = null
        set(value) {
            field = value ?: context.getString(R.string.prompt_loading)
        }

    private val mBindViews by lazy { ArrayList<View>() }

    init {
        View.inflate(context, R.layout.layout_empty, this)

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.PlaceHolderView, defStyle, 0)

        with(typeArray) {
            emptyDrawable = getResourceId(R.styleable.PlaceHolderView_emptyDrawable, defaultDrawable)
            errorDrawable = getResourceId(R.styleable.PlaceHolderView_errorDrawable, defaultDrawable)

            loadingColor = getColor(R.styleable.PlaceHolderView_loadingColor, defaultColor)

            emptyText = getString(R.styleable.PlaceHolderView_emptyText)
            errorText = getString(R.styleable.PlaceHolderView_errorText)
            loadingText = getString(R.styleable.PlaceHolderView_loadingText)

            recycle()
        }

    }

    fun add(vararg views: View) {
        views.forEach {
            mBindViews.add(it)
        }
    }

    private fun changeBindViewState(visible: Int) {
        val views = mBindViews

        views.isNotEmpty().let {
            views.forEach { view ->
                view.visibility = visible
            }
        }
    }

    /**
     *  没有数据
     *  显示空布局, 隐藏当前数据布局
     */
    fun triggerEmpty(msg: String? = null, @DrawableRes icon: Int? = null) {
        loading.visibility = View.GONE
        loading.stop()

        mIvImage.setImageResource(icon ?: defaultDrawable)
        mTvTips.text = msg ?: emptyText

        this.visibility = View.VISIBLE
        changeBindViewState(View.GONE)
    }

    /**
     *  网络错误
     *  显示一个网络错误的图标
     */
    fun triggerNetError(msg: String? = null, @DrawableRes icon: Int? = null) {
        loading.visibility = View.GONE
        loading.stop()
        mIvImage.setImageResource(icon ?: defaultDrawable)
        mTvTips.text = msg ?: errorText

        this.visibility = View.VISIBLE
        changeBindViewState(View.GONE)
    }

    /**
     * 加载错误, 并显示错误信息
     */
    fun triggerError(str: String) {
        context.toast(str)

        this.visibility = View.VISIBLE
        changeBindViewState(View.GONE)
    }

    /**
     * 显示正在加载的状态
     */
    fun triggerLoading() {
        mIvImage.visibility = View.GONE
        loading.visibility = View.VISIBLE
        loading.start()
        mTvTips.text = loadingText

        this.visibility = View.VISIBLE
        changeBindViewState(View.GONE)
    }

    /**
     * 数据加载成功,调用该方法时应该隐藏当前占位布局
     */
    fun triggerOk() {
        this.visibility = View.GONE
        changeBindViewState(View.VISIBLE)
    }

    /**
     * 该方法如果传入的isOk为True则为成功状态，
     * 此时隐藏布局，反之显示空数据布局
     *
     * @param isOk 是否加载成功数据
     */
    fun triggerOkOrEmpty(isOk: Boolean) {
        if (isOk) {
            triggerOk()
        } else {
            triggerEmpty()
        }
    }
}