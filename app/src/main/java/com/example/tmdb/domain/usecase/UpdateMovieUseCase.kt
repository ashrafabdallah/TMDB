package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.repository.MovieReposatory

class UpdateMovieUseCase(private val movieReposatory: MovieReposatory) {

    suspend fun executeUpdateMovies():List<Movie>? = movieReposatory.updateMovies()
}