package com.sunchildapps.pruebavalid.service.response.artist

import com.google.gson.annotations.SerializedName
import com.sunchildapps.pruebavalid.domain.Artist

class TopArtistsResponse(
   @SerializedName("artist")
   val artistResponse: List<Artist>
)