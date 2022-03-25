package com.example.tmdb.data.reposatory.movie.datasource

import com.example.tmdb.data.model.movie.Movie

interface MovieLocalDataSourse {
    suspend fun getMovieListFromDB():List<Movie>
    suspend fun saveMovieListtoDB(movieList:List<Movie>)
    suspend fun clearAll()
}