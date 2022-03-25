package com.example.tmdb.data.reposatory.artist.datasourse

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemotDataSourse {

    suspend fun getArtist():Response<ArtistList>
}