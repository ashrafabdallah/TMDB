package com.example.tmdb.data.reposatory.tvshow.datasourseimpl

import com.example.tmdb.data.db.DaoTvShow
import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowLocalDBResours
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataResourseIMPL(private val daoTvShow: DaoTvShow) : TvShowLocalDBResours {
    override suspend fun getTvShow(): List<TvShow> {
        return daoTvShow.getTvShows()
    }

    override suspend fun saveTvShow(tvshowlist: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            daoTvShow.save_TvShow(tvshowlist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            daoTvShow.dalete_TvShows()
        }
    }
}