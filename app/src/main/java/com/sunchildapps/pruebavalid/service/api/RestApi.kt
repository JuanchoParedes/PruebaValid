package com.sunchildapps.pruebavalid.service.api

import com.sunchildapps.pruebavalid.domain.Track
import com.sunchildapps.pruebavalid.service.response.artist.ArtistsBaseResponse
import com.sunchildapps.pruebavalid.service.response.artist.TopArtistsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

const val value = "2.0/"

interface RestApi {
    @GET(value)
    fun getTopArtists(
        @Query("page") page: Int,
        @Query("method") method: String = "geo.gettopartists"
    ): Observable<ArtistsBaseResponse<TopArtistsResponse>>

    @GET(value)
    fun getTopTracks(
        @Query("page") page: Int,
        @Query("method") method: String = "geo.gettoptracks"
    ): Observable<List<Track>>
}