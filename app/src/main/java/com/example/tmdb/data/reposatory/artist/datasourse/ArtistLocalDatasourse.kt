package com.example.tmdb.data.reposatory.artist.datasourse

import com.example.tmdb.data.model.artist.Artist

interface ArtistLocalDatasourse {
    suspend fun getArtistFromDb():List<Artist>
    suspend fun saveArtist(artists: List<Artist>)
    suspend fun clearAll()
}