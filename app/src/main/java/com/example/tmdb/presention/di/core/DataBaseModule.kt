package com.example.tmdb.presention.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb.data.db.DaoArtist
import com.example.tmdb.data.db.DaoMovie
import com.example.tmdb.data.db.DaoTvShow
import com.example.tmdb.data.db.TmbdDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TmbdDataBase {
        return Room.databaseBuilder(context, TmbdDataBase::class.java, "tmbdbase").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmbdDataBase: TmbdDataBase): DaoMovie {
        return tmbdDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmbdDataBase: TmbdDataBase): DaoArtist {
        return tmbdDataBase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmbdDataBase: TmbdDataBase): DaoTvShow {
        return tmbdDataBase.tvShowDao()
    }
}