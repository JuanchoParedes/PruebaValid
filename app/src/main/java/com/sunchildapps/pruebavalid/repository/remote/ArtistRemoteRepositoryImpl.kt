package com.sunchildapps.pruebavalid.repository.remote

import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.service.api.RetrofitClient
import io.reactivex.Observable

class ArtistRemoteRepositoryImpl : RetrofitClient(),
    ArtistRemoteRepository {
    override fun getArtists(page: Int): Observable<List<Artist>> {
        return createService().getTopArtists(page).flatMap {
            Observable.fromArray(it.topartists.artistResponse)
        }
    }
}