package com.example.tmdb.data.reposatory.movie.datasource

import com.example.tmdb.data.model.movie.Movie

interface MovieCachDataSourse {
    suspend fun getMoviesFromCach():List<Movie>
    suspend fun saveMovieToCach(movielist:List<Movie>)
}