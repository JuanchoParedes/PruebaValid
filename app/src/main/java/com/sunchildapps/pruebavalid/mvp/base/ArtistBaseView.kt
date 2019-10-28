package com.sunchildapps.pruebavalid.mvp.base

import com.sunchildapps.pruebavalid.domain.Artist

interface ArtistBaseView: MvpView {

    fun showArtists(artists: List<Artist>)
    fun showLoading()
    fun hideLoading()
    fun showError(error: String)
}