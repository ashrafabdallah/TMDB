package com.example.tmdb.presention.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.usecase.GetMovieUseCase
import com.example.tmdb.domain.usecase.UpdateMovieUseCase

class MovieViewModelProvider(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
        }
        throw IllegalAccessException("Unknown View Model")
    }
}