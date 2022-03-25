package com.example.tmdb.data.reposatory.tvshow.datasourse

import com.example.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteResours {
    suspend fun getTvShow():Response<TvShowList>
}