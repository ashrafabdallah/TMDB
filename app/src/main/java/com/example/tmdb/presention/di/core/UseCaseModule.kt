package com.example.tmdb.presention.di.core

import com.example.tmdb.domain.repository.AtristRepostory
import com.example.tmdb.domain.repository.MovieReposatory
import com.example.tmdb.domain.repository.TvShowRepostory
import com.example.tmdb.domain.usecase.*

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieReposatory: MovieReposatory): GetMovieUseCase {
        return GetMovieUseCase(movieReposatory)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieReposatory: MovieReposatory): UpdateMovieUseCase {
        return UpdateMovieUseCase (movieReposatory)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepostory: TvShowRepostory): GetTvShowUseCase {
        return  GetTvShowUseCase (tvShowRepostory)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepostory: TvShowRepostory): UpdateTvUseCases{
        return  UpdateTvUseCases (tvShowRepostory)
    }
    @Singleton
    @Provides
    fun provideGetArtistUseCase(atristRepostory: AtristRepostory): GetArtistUseCase{
        return  GetArtistUseCase (atristRepostory)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(atristRepostory: AtristRepostory): UpdateArtistUseCase{
        return  UpdateArtistUseCase (atristRepostory)
    }
}