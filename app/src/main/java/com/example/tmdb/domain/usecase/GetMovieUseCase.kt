package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.repository.MovieReposatory

class GetMovieUseCase(private val movieReposatory: MovieReposatory) {


    suspend fun excuteGetMovie():List<Movie>? = movieReposatory.getMovie()


}