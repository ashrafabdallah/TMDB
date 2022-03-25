package com.example.tmdb.data.reposatory.tvshow.datasourse

import com.example.tmdb.data.model.tvshow.TvShow

interface TvShowCacheResourse {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShowlist:List<TvShow>)
}