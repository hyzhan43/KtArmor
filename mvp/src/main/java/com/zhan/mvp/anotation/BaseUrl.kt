package com.zhan.mvp.anotation

/**
 *  author:  hyzhan
 *  date:    2020/2/24
 *  desc:    TODO
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class BaseUrl(val value: String) {
}