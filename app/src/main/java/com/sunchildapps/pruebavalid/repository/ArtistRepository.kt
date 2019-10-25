package com.sunchildapps.pruebavalid.repository

import com.sunchildapps.pruebavalid.domain.Artist
import io.reactivex.Observable

interface ArtistRepository {
    fun getArtists(page: Int): Observable<List<Artist>>
}