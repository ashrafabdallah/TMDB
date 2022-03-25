package com.example.tmdb.presention.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.usecase.GetTvShowUseCase
import com.example.tmdb.domain.usecase.UpdateTvUseCases

class TvShowViewModelProvider(private val getTvShowUseCase: GetTvShowUseCase,
                              private val updateTvUseCases: UpdateTvUseCases
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TvShowViewModel::class.java)){
            return TvShowViewModel(getTvShowUseCase,updateTvUseCases) as T
        }
        throw IllegalAccessException("Unknown View Model")
    }
}