package com.sunchildapps.pruebavalid.mvp.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : MvpPresenter<MvpView>>: AppCompatActivity(), MvpView {
}