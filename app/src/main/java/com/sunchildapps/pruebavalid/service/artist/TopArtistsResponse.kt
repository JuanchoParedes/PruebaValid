package com.sunchildapps.pruebavalid.service.artist

import com.google.gson.annotations.SerializedName

class TopArtistsResponse(
   @SerializedName("artist")
   val artistResponse: List<ArtistResponse>
)