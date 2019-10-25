package com.sunchildapps.pruebavalid.service.response.track

data class TrackResponse(
    val name: String,
    val duration: Long,
    val listeners: Long,
    val mbid: String,
    val url: String
)