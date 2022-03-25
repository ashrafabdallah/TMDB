package com.example.tmdb.data.reposatory.artist.datasourseimpl

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistCacheDataBaseResours

class ArtistCacheDBIMPL : ArtistCacheDataBaseResours {
    private var artisList= ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
       return artisList
    }

    override suspend fun saveArtisttoCache(artists: List<Artist>) {
        artisList.clear()
        artisList= ArrayList(artists)
    }
}