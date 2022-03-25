package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.domain.repository.TvShowRepostory

class GetTvShowUseCase (private val tvShowRepostory: TvShowRepostory){
    suspend fun executeGetTvShow():List<TvShow>?= tvShowRepostory.getTvShow()
}