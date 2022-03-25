package com.example.tmdb.presention.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.databinding.ListItemBinding
import java.util.zip.Inflater

class TVShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {
    private  var TvShowlist =  ArrayList<TvShow>()
    fun setTvShowList(tvlist: List<TvShow>) {
        TvShowlist.clear()
        TvShowlist.addAll(tvlist)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(TvShowlist.get(position))

    }

    override fun getItemCount(): Int {
        return TvShowlist.size
    }
}

class TvShowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvshow: TvShow) {
        binding.titleTextView.text = tvshow.name
        binding.descriptionTextView.text = tvshow.overview
        val path = "https://image.tmdb.org/t/p/w500" + tvshow.posterPath
        Glide.with(binding.imageView.context)
            .load(path)
            .into(binding.imageView)
    }

}