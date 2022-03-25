package com.example.tmdb.presention.di.core

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistRemotDataSourse
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistRemoteDBIMPL
import com.example.tmdb.data.reposatory.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.data.reposatory.movie.datasourceimpl.MovieRemoteDataBaseSoursIMPL
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowRemoteResours
import com.example.tmdb.data.reposatory.tvshow.datasourseimpl.TvShowRemoteDBresoursIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModul(private val api_key: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataResource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataBaseSoursIMPL(tmdbService, api_key)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataResource(tmdbService: TMDBService): TvShowRemoteResours {
        return TvShowRemoteDBresoursIMPL(tmdbService, api_key)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataResource(tmdbService: TMDBService): ArtistRemotDataSourse {
        return ArtistRemoteDBIMPL(tmdbService, api_key)
    }
}