package com.sunchildapps.pruebavalid.mvp

import com.sunchildapps.pruebavalid.mvp.base.BasePresenter
import com.sunchildapps.pruebavalid.mvp.base.BaseView

abstract class ArtistPresenter: BasePresenter<BaseView>() {
    abstract fun getArtists()
}