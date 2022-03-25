package com.example.tmdb.presention.di.core

import com.example.tmdb.data.db.DaoArtist
import com.example.tmdb.data.db.DaoMovie
import com.example.tmdb.data.db.DaoTvShow
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistLocalDatasourse
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistLocalDBIMPL
import com.example.tmdb.data.reposatory.movie.datasource.MovieLocalDataSourse
import com.example.tmdb.data.reposatory.movie.datasourceimpl.MovieLocalDataSourceIMPL
import com.example.tmdb.data.reposatory.tvshow.datasourse.TvShowLocalDBResours
import com.example.tmdb.data.reposatory.tvshow.datasourseimpl.TvShowLocalDataResourseIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataBaseModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataBaseResours(daoMovie: DaoMovie): MovieLocalDataSourse {
        return MovieLocalDataSourceIMPL(daoMovie)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataBaseResours(daoTvshow: DaoTvShow): TvShowLocalDBResours {
        return TvShowLocalDataResourseIMPL(daoTvshow)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataBaseResours(daoArtist: DaoArtist): ArtistLocalDatasourse {
        return ArtistLocalDBIMPL(daoArtist)
    }
}