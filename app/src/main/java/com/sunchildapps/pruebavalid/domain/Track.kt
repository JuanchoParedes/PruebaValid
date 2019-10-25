package com.sunchildapps.pruebavalid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_tracks")
data class Track (
    val name: String,
    val duration: Long,
    val listeners: Long,
    @PrimaryKey val mbid: String,
    val url: String
)