package com.example.tmdb.domain.usecase

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.domain.repository.AtristRepostory

class GetArtistUseCase(private val artistrepostory: AtristRepostory) {
    suspend fun executeGetArtist():List<Artist>?= artistrepostory.getArtist()
}