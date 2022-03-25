package com.example.tmdb.data.reposatory.artist.datasourseimpl

import com.example.tmdb.data.db.DaoArtist
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.reposatory.artist.datasourse.ArtistLocalDatasourse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDBIMPL(private val daoArtist: DaoArtist) : ArtistLocalDatasourse {
    override suspend fun getArtistFromDb(): List<Artist> {
       return daoArtist.getArtist()
    }

    override suspend fun saveArtist(artists: List<Artist>) {
       CoroutineScope(Dispatchers.IO).launch {
           daoArtist.save_Artist(artists)
       }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           daoArtist.delete_Artists()
       }
    }
}