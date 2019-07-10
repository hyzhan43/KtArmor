package com.zhan.mvp.ext

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
// R.color.xxx  -> @ColorInt
fun Context.getColorRef(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.getDrawableRef(@DrawableRes res: Int): Drawable? {
    return ContextCompat.getDrawable(this, res)
}

fun View.getColorRef(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this.context, res)
}

fun View.getDrawableRef(@DrawableRes res: Int): Drawable? {
    return ContextCompat.getDrawable(this.context, res)
}

