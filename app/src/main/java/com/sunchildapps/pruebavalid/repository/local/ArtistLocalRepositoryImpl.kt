package com.sunchildapps.pruebavalid.repository.local

import com.sunchildapps.pruebavalid.data.ArtistDao
import com.sunchildapps.pruebavalid.domain.Artist
import io.reactivex.Observable

class ArtistLocalRepositoryImpl(//Dagger
    private val artistDao: ArtistDao
): ArtistLocalRepository {
    override fun getArtists(): Observable<List<Artist>> {
        return Observable.fromCallable {
            artistDao.getTopArtists()
        }
    }

    override fun insertArtist(artists: List<Artist>) {
        artistDao.insert(artists)
    }
}