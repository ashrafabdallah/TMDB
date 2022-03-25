package com.example.tmdb.presention.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.usecase.GetArtistUseCase
import com.example.tmdb.domain.usecase.UpdateArtistUseCase

class ArtistViewModelProvider(private val getArtistUseCase: GetArtistUseCase,
                              private val updateArtistUseCase: UpdateArtistUseCase
) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(ArtistViewModel::class.java))
       {
           return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
       }
        throw IllegalAccessException("Unknown View Model")
    }
}