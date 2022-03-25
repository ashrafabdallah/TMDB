package com.example.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.model.tvshow.TvShow


@Dao
interface DaoTvShow {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save_TvShow(Tvlist:List<TvShow>)

    @Query("DELETE FROM popular_tv_show")
    suspend fun dalete_TvShows()
    @Query("SELECT * FROM popular_tv_show")
    suspend fun getTvShows():List<TvShow>
}