package com.zhan.mvp.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.util.Log
import android.util.TypedValue
import com.zhan.mvp.utils.IntentUtils
import java.io.Serializable
import java.lang.Exception

/**
 *  @author: hyzhan
 *  @date:   2019/5/21
 *  @desc:   TODO
 */
inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) {
    val intent = Intent(this, T::class.java)
    if (params.isNotEmpty()) IntentUtils.fillIntentArguments(intent, params)
    this.startActivity(intent)
}

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) {
    val intent = Intent(context, T::class.java)
    if (params.isNotEmpty()) IntentUtils.fillIntentArguments(intent, params)
    activity?.startActivity(intent)
}


fun Context.log(message: String) {
    Log.d(this.javaClass.name, message)
}

fun String.showLog() {
    Log.d(this.javaClass.name, "<-------------------KtArmor Start--------------------")
    Log.d(this.javaClass.name, "${this.javaClass.name}:  $this")
    Log.d(this.javaClass.name, "--------------------KtArmor End------------------->")
}

inline fun tryCatch(tryBlock: () -> Unit, catchBlock: (Throwable) -> Unit = {}) {
    try {
        tryBlock()
    } catch (t: Throwable) {
        t.toString().showLog()
        catchBlock(t)
    }
}


val Float.dp: Float
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Int.dp: Int
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()


val Float.sp: Float
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)


val Int.sp: Int
    get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()