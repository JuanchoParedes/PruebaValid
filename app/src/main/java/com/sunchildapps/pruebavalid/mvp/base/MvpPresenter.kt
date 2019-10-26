package com.sunchildapps.pruebavalid.mvp.base

interface MvpPresenter<P : MvpView> {

    fun onAttach(view: P)

    fun onResume()

    fun onDetach()
}