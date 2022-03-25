package com.example.tmdb.presention.di.artist

import com.example.tmdb.domain.usecase.GetArtistUseCase
import com.example.tmdb.domain.usecase.UpdateArtistUseCase
import com.example.tmdb.presention.artist.ArtistViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelProvider {
        return ArtistViewModelProvider(getArtistUseCase, updateArtistUseCase)
    }

}