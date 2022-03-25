package com.example.tmdb.data.reposatory.tvshow.datasourseimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.tvshow.TvShowList
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowRemoteResours
import retrofit2.Response

class TvShowRemoteDBresoursIMPL(
    private val tmdbService: TMDBService,
    private val api_Key: String
) :
    TvShowRemoteResours {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTvShow(api_Key)
    }
}