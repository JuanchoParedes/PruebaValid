package com.sunchildapps.pruebavalid.mvp.base

interface BaseView: MvpView {

    fun <T>showObjects(objects: List<T>)
    fun showLoading()
    fun hideLoading()
    fun showError(error: String)
}