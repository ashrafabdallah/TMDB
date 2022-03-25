package com.example.tmdb.presention.di.core

import com.example.tmdb.data.reposatory.artist.ArtistReposoryIMPL
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistCacheDataBaseResours
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistLocalDatasourse
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistRemotDataSourse
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistRemoteDBIMPL
import com.example.tmdb.data.reposatory.movie.MovieRepostoryIMPL
import com.example.tmdb.data.reposatory.movie.datasource.MovieCachDataSourse
import com.example.tmdb.data.reposatory.movie.datasource.MovieLocalDataSourse
import com.example.tmdb.data.reposatory.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.data.reposatory.tvshow.TvShowRpostoryIMPL
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowCacheResourse
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowLocalDBResours
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowRemoteResours
import com.example.tmdb.domain.repository.AtristRepostory
import com.example.tmdb.domain.repository.MovieReposatory
import com.example.tmdb.domain.repository.TvShowRepostory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposatoryModule {


    @Singleton
    @Provides
    fun provideMovieRepostory(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieCachDataSourse: MovieCachDataSourse,
        movieLocalDataSourse: MovieLocalDataSourse
    ): MovieReposatory {
        return MovieRepostoryIMPL(movieRemoteDataSource, movieCachDataSourse, movieLocalDataSourse)
    }

    @Singleton
    @Provides
    fun provideTvShowRepostory(
        tvShowRemoteResours: TvShowRemoteResours,
        tvShowCacheResourse: TvShowCacheResourse,
        tvShowLocalDBResours: TvShowLocalDBResours
    ): TvShowRepostory {
        return TvShowRpostoryIMPL(tvShowCacheResourse, tvShowRemoteResours, tvShowLocalDBResours)
    }

    @Singleton
    @Provides
    fun provideArtistRepostory(
        artistRemotDataSourse: ArtistRemotDataSourse,
        artistCacheDataBaseResours: ArtistCacheDataBaseResours,
        artistLocalDatasourse: ArtistLocalDatasourse
    ): AtristRepostory {
        return ArtistReposoryIMPL(
            artistCacheDataBaseResours,
            artistLocalDatasourse,
            artistRemotDataSourse
        )
    }

}