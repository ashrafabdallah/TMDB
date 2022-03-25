package com.example.tmdb.data.reposatory.artist

import android.util.Log
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistCacheDataBaseResours
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistLocalDatasourse
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistRemotDataSourse
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistCacheDBIMPL
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistLocalDBIMPL
import com.example.tmdb.data.reposatory.artist.datasourseimpl.ArtistRemoteDBIMPL
import com.example.tmdb.domain.repository.AtristRepostory
import retrofit2.Response
import java.lang.Exception

class ArtistReposoryIMPL(
    private val artistCacheDataBaseResours: ArtistCacheDataBaseResours,
    private val artistLocalDatasourse: ArtistLocalDatasourse,
    private val artistRemotDataSourse: ArtistRemotDataSourse

) : AtristRepostory {
    override suspend fun getArtist(): List<Artist>? {
        return artistCacheDataBaseResours.getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        var newArtistList: List<Artist>? = getArtistFromApi()
        artistLocalDatasourse.clearAll()
        if (newArtistList != null) {
            artistLocalDatasourse.saveArtist(newArtistList)
            artistCacheDataBaseResours.saveArtisttoCache(newArtistList)
        }
        return newArtistList
    }

    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            var respons = artistRemotDataSourse.getArtist()
            var body = respons.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (e: Exception) {
            Log.i("Mytag", e.message.toString())
        }
        return artists

    }

    suspend fun getArtistFromLocalDB(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            artists = artistLocalDatasourse.getArtistFromDb()

        } catch (e: Exception) {
            Log.i("Mytag", e.message.toString())

        }

        if (artists.size > 0) {
            artists
        } else {
            artists = getArtistFromApi()
            artistLocalDatasourse.saveArtist(artists)
        }
        return artists

    }
}