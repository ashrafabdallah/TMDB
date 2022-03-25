package com.example.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.tvshow.TvShow

@Database(entities = [Artist::class,Movie::class,TvShow::class], version = 1, exportSchema = false)
abstract class TmbdDataBase :RoomDatabase() {

    abstract fun movieDao(): DaoMovie
    abstract fun artistDao(): DaoArtist
    abstract fun tvShowDao(): DaoTvShow
}