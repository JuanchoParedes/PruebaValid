package com.sunchildapps.pruebavalid.service.artist

data class ArtistResponse(
    val name: String,
    val listeners: Long? = null,
    val mbid: String
)