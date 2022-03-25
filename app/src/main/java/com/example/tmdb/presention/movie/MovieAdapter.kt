package com.example.tmdb.presention.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.databinding.ListItemBinding

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>(){
    private val movieList = ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
     return  movieList.size
    }


}
class MovieViewHolder(private val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(movie:Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}
