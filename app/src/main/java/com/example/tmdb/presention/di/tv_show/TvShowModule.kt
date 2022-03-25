package com.example.tmdb.presention.di.tv_show

import com.example.tmdb.domain.usecase.*
import com.example.tmdb.presention.artist.ArtistViewModelProvider
import com.example.tmdb.presention.di.movie.MovieScope

import com.example.tmdb.presention.movie.MovieViewModelProvider
import com.example.tmdb.presention.tvshow.TvShowViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
  getTvShowUseCase: GetTvShowUseCase,updateTvUseCases: UpdateTvUseCases
    ): TvShowViewModelProvider {
        return TvShowViewModelProvider(getTvShowUseCase,updateTvUseCases)
    }

}