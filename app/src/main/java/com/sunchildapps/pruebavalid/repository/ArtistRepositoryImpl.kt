package com.sunchildapps.pruebavalid.repository

import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.repository.local.ArtistLocalRepository
import com.sunchildapps.pruebavalid.repository.remote.ArtistRemoteRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ArtistRepositoryImpl(//do it with dagger
    private val remoteRepo: ArtistRemoteRepository,
    private val localRepo: ArtistLocalRepository
) : ArtistRepository {
    override fun getArtists(page: Int): Observable<List<Artist>> {
        return Observable.mergeDelayError(
            remoteRepo.getArtists(page).doOnNext { artists ->
                localRepo.insertArtist(
                    artists
                )
            }.subscribeOn(Schedulers.io()),
            localRepo.getArtists().subscribeOn(Schedulers.io())
        )
    }
}