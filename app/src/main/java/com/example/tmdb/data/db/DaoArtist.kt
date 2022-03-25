package com.example.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.model.artist.Artist

@Dao
interface DaoArtist {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save_Artist(atistList:List<Artist>)
    @Query("DELETE FROM popular_artist")
    suspend fun delete_Artists()
    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist():List<Artist>
}