package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.tvshow.TvShow

interface TvShowRepostory {

    suspend fun getTvShow():List<TvShow>?
    suspend fun updateTvShow():List<TvShow>?
}