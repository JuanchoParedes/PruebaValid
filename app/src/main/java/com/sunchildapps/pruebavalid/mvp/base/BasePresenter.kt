package com.sunchildapps.pruebavalid.mvp.base

import java.lang.ref.WeakReference

open class BasePresenter<P : MvpView> : MvpPresenter<P> {
    private var viewReference: WeakReference<P>? = null

    override fun onAttach(view: P) {
        viewReference = WeakReference(view)
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDetach() {
        viewReference?.clear()
        viewReference = null
    }

    protected fun isViewAttached(): Boolean {
        return viewReference?.get() != null
    }

    protected fun getView(): P? {
        return viewReference?.get()
    }
}