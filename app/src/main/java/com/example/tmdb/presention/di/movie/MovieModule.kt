package com.example.tmdb.presention.di.movie

import com.example.tmdb.domain.usecase.GetArtistUseCase
import com.example.tmdb.domain.usecase.GetMovieUseCase
import com.example.tmdb.domain.usecase.UpdateArtistUseCase
import com.example.tmdb.domain.usecase.UpdateMovieUseCase
import com.example.tmdb.presention.artist.ArtistViewModelProvider

import com.example.tmdb.presention.movie.MovieViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
     getMovieUseCase: GetMovieUseCase,updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelProvider {
        return MovieViewModelProvider(getMovieUseCase, updateMovieUseCase)
    }

}