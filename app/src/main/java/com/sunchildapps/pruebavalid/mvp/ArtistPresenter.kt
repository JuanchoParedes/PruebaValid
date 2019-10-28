package com.sunchildapps.pruebavalid.mvp

import com.sunchildapps.pruebavalid.mvp.base.BasePresenter
import com.sunchildapps.pruebavalid.mvp.base.ArtistBaseView

abstract class ArtistPresenter: BasePresenter<ArtistBaseView>() {
    abstract fun getArtists()
}