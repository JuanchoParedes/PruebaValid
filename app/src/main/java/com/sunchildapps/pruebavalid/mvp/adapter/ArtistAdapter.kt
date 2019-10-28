package com.sunchildapps.pruebavalid.mvp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunchildapps.pruebavalid.R
import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.mvp.extension.inflate
import kotlinx.android.synthetic.main.artist_itemview.view.*

class ArtistAdapter(
    val listener: (Artist)-> Unit,
    val items: List<Artist> = emptyList()
    ) : RecyclerView.Adapter<ArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder =
        ArtistViewHolder(
            parent.inflate(R.layout.artist_itemview),
            listener
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
       holder.bind(items[position])
    }
}

class ArtistViewHolder(itemView: View, val listener: (Artist) -> Unit) : RecyclerView.ViewHolder(itemView) {
    fun bind(artist: Artist) = with(itemView){
        tv_name.text = artist.name
        tv_listeners.text = artist.listeners.toString()
        tv_mbid.text = artist.mbid
        tv_url.text = artist.url
        setOnClickListener{ listener(artist) }
    }
}