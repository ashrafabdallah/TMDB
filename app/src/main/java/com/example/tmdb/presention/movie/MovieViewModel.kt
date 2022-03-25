package com.example.tmdb.presention.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.usecase.GetMovieUseCase
import com.example.tmdb.domain.usecase.UpdateMovieUseCase

class MovieViewModel(private val getMovieUseCase: GetMovieUseCase,private val updateMovieUseCase: UpdateMovieUseCase) :ViewModel(){

    fun getmovie():LiveData<List<Movie>?> = liveData {
        val movielist=getMovieUseCase.excuteGetMovie()
        emit(movielist)
    }
    fun updateMovie():LiveData<List<Movie>?> = liveData {
        val movielist=updateMovieUseCase.executeUpdateMovies()
        emit(movielist)
    }

}