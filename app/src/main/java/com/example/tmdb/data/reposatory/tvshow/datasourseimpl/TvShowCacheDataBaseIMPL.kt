package com.example.tmdb.data.reposatory.tvshow.datasourseimpl

import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowCacheResourse

class TvShowCacheDataBaseIMPL : TvShowCacheResourse {
    private var tvshowListss = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvshowListss
    }

    override suspend fun saveTvShowToCache(tvShowlist: List<TvShow>) {
        tvshowListss.clear()
        tvshowListss = ArrayList(tvShowlist)

    }
}