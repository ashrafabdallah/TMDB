package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.domain.repository.TvShowRepostory

class UpdateTvUseCases (private val tvShowRepostory: TvShowRepostory) {
    suspend fun executeUpdateTvShow():List<TvShow>?= tvShowRepostory.updateTvShow()
}