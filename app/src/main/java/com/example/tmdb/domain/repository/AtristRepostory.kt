package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.artist.Artist

interface AtristRepostory {

    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?

}