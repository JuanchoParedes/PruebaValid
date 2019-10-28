package com.sunchildapps.pruebavalid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_artists")
data class Artist(
    val name: String,
    val listeners: Long? = null,
    val url: String,
    @PrimaryKey val mbid: String
)