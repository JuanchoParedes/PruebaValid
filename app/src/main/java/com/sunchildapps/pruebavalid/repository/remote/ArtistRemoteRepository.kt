package com.sunchildapps.pruebavalid.repository.remote

import com.sunchildapps.pruebavalid.domain.Artist
import io.reactivex.Observable

interface ArtistRemoteRepository {
    fun getArtists(page: Int): Observable<List<Artist>>
}