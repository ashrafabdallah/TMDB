package com.example.tmdb.presention.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.domain.usecase.GetTvShowUseCase
import com.example.tmdb.domain.usecase.UpdateTvUseCases

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvUseCases: UpdateTvUseCases
) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShow>?> = liveData {
        var tvshowList = getTvShowUseCase.executeGetTvShow()
        emit(tvshowList)
    }
    fun updateTvShow(): LiveData<List<TvShow>?> = liveData {
        var tvshowList = updateTvUseCases.executeUpdateTvShow()
        emit(tvshowList)
    }
}