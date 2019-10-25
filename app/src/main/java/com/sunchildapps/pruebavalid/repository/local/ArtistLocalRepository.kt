package com.sunchildapps.pruebavalid.repository.local

import com.sunchildapps.pruebavalid.domain.Artist
import io.reactivex.Observable

interface ArtistLocalRepository {
    fun getArtists(): Observable<List<Artist>>
    fun insertArtist(artists: List<Artist>)

}