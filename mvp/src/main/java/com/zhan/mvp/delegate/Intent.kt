package com.zhan.mvp.delegate

import android.app.Activity
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  author:  hyzhan
 *  date:    2019/12/26
 *  desc:    TODO
 */
class Intent<T>(val name: String,private val default: T) : ReadWriteProperty<Activity?, T> {

    override fun getValue(thisRef: Activity?, property: KProperty<*>): T = findPreference(thisRef)

    override fun setValue(thisRef: Activity?, property: KProperty<*>, value: T) {
        putPreference(thisRef, value)
    }

    @Suppress("UNCHECKED_CAST")
    private fun findPreference(thisRef: Activity?): T {
        return thisRef?.intent?.run {
            val res: Any = when (default) {
                is Long -> getLongExtra(name, default)
                is String -> getStringExtra(name) ?: default
                is Int -> getIntExtra(name, default)
                is Boolean -> getBooleanExtra(name, default)
                is Float -> getFloatExtra(name, default)
                else -> throw IllegalArgumentException("This type can be get from Intent")
            }
            res as T
        } ?: throw IllegalArgumentException("This activity can be get intent")
    }

    private fun <T> putPreference(activity: Activity?, value: T) {
        activity?.intent?.run {
            when (value) {
                is Long -> putExtra(name, value)
                is String -> putExtra(name, value)
                is Int -> putExtra(name, value)
                is Boolean -> putExtra(name, value)
                is Float -> putExtra(name, value)
                else -> throw IllegalArgumentException("This type can be saved into Intent")
            }
        }
    }
}