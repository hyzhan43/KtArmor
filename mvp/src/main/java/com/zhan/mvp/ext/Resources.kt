package com.zhan.mvp.ext

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

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