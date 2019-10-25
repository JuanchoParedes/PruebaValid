package com.sunchildapps.pruebavalid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sunchildapps.pruebavalid.domain.Artist
import io.reactivex.Flowable

@Dao
interface ArtistDao {
    @Query("SELECT * FROM top_artists")
    fun getTopArtists(): List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(artists: List<Artist>)
}