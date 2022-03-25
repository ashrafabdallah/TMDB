package com.example.tmdb.data.reposatory.artist.datasourse

import com.example.tmdb.data.model.artist.Artist

interface ArtistCacheDataBaseResours {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtisttoCache(artists : List<Artist>)
}