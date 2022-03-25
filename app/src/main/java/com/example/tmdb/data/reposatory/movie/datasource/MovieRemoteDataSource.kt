package com.example.tmdb.data.reposatory.movie.datasource

import com.example.tmdb.data.model.movie.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MoviesList>
}