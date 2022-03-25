package com.example.tmdb.data.reposatory.movie.datasourceimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.movie.MoviesList
import com.example.tmdb.data.reposatory.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataBaseSoursIMPL(private val tmdbservice: TMDBService, var api_key: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MoviesList> {

      return  tmdbservice.getPopularMovie(api_key)
    }
}