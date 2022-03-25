package com.example.tmdb.presention.artist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    private var artistlist = ArrayList<Artist>()
    fun setArtistList(artists: List<Artist>) {
        artistlist.clear()
        artistlist.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistlist.get(position))
    }

    override fun getItemCount(): Int {
        return artistlist.size
    }
}

class ArtistViewHolder(private var binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.visibility = View.GONE
        val url = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imageView.context)
            .load(url)
            .into(binding.imageView)

    }
}