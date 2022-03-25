package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.domain.repository.AtristRepostory

class UpdateArtistUseCase(private val artistrepostory: AtristRepostory) {
    suspend fun executeUpadteArtist():List<Artist>?=artistrepostory.updateArtist()
}