package com.example.tmdb.presention.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.domain.usecase.GetArtistUseCase
import com.example.tmdb.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist(): LiveData<List<Artist>?> = liveData {
        var artistlist = getArtistUseCase.executeGetArtist()
        emit(artistlist)
    }

    fun updateArtist(): LiveData<List<Artist>?> = liveData {
        var artistlist = updateArtistUseCase.executeUpadteArtist()
        emit(artistlist)
    }
}