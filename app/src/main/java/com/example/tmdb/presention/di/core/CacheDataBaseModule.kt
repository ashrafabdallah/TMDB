package com.example.tmdb.presention.di.core

import com.example.tmdb.data.reposatory.artist.datasourse.ArtistCacheDataBaseResours
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistCacheDBIMPL
import com.example.tmdb.data.reposatory.movie.datasource.MovieCachDataSourse
import com.example.tmdb.data.reposatory.movie.datasourceimpl.MovieCacheDataSourceIMPL
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowCacheResourse
import com.example.tmdb.data.reposatory.tvshow.datasourseimpl.TvShowCacheDataBaseIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataBaseModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataReSource():MovieCachDataSourse
    {
        return MovieCacheDataSourceIMPL()
    }

    @Singleton
    @Provides
    fun provideTvShoWCacheDataReSource():TvShowCacheResourse
    {
        return TvShowCacheDataBaseIMPL()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataReSource():ArtistCacheDataBaseResours
    {
        return ArtistCacheDBIMPL()
    }

}