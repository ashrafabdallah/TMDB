package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.movie.Movie

interface MovieReposatory {
    suspend fun getMovie():List<Movie>?

    suspend fun updateMovies() :List<Movie>?
}