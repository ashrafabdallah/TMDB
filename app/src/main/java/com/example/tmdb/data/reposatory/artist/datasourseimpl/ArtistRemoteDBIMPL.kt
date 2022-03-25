package com.example.tmdb.data.reposatory.artist.datasourseimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistRemotDataSourse
import retrofit2.Response

class ArtistRemoteDBIMPL(private val tmdbService: TMDBService,private val api_key:String) :
    ArtistRemotDataSourse {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(api_key)
    }
}