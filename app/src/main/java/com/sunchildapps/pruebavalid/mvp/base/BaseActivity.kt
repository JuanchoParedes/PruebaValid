package com.sunchildapps.pruebavalid.mvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : MvpPresenter<MvpView>> : AppCompatActivity(), MvpView {

    private lateinit var presenter: T

    private fun getPresenter(): T = createPresenter()

    abstract fun createPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter().onAttach(this)
    }

    override fun onResume() {
        super.onResume()
        getPresenter().onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().onDetach()
    }
}