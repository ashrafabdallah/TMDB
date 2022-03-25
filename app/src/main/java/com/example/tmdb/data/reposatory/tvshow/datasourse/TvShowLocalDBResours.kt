package com.example.tmdb.data.reposatory.tvshow.datasourse

import com.example.tmdb.data.model.tvshow.TvShow

interface TvShowLocalDBResours {
    suspend fun getTvShow():List<TvShow>
    suspend fun saveTvShow(tvshowlist:List<TvShow>)
    suspend fun clearAll()
}