package com.example.tmdb.data.reposatory.tvshow

import android.util.Log
import com.example.tmdb.data.model.tvshow.TvShow
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowCacheResourse
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowLocalDBResours
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowRemoteResours
import com.example.tmdb.domain.repository.TvShowRepostory

class TvShowRpostoryIMPL(
    private val tvShowCacheResourse: TvShowCacheResourse,
    private val tvShowRemoteResours: TvShowRemoteResours,
    private val tvShowLocalDBResours: TvShowLocalDBResours

) : TvShowRepostory {
    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowFromCacheDataBase()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        var newTvShowList: List<TvShow> = getTvShowFromApi()
        tvShowLocalDBResours.clearAll()
        tvShowLocalDBResours.saveTvShow(newTvShowList)
        tvShowCacheResourse.saveTvShowToCache(newTvShowList)
        return newTvShowList

    }

    suspend fun getTvShowFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        var response = tvShowRemoteResours.getTvShow()
        var body = response.body()
        try {
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("Mytag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromLocalDataBase(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDBResours.getTvShow()
        } catch (e: Exception) {
            Log.i("Mytag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromApi()
            tvShowLocalDBResours.saveTvShow(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCacheDataBase(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheResourse.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i("Mytag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromLocalDataBase()
            tvShowCacheResourse.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}