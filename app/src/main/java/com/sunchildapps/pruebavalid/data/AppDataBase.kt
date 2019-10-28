package com.sunchildapps.pruebavalid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.domain.Track

@Database(entities = [Track::class, Artist::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun artistDao(): ArtistDao
//    abstract fun trackDao(): TrackDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "prueba_valid_db"
            ).build()
        }
    }
}