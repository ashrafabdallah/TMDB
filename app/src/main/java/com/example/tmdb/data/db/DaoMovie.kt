package com.example.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.movie.MoviesList

@Dao
interface DaoMovie {

    // علشان كل معمل حفظ للبيانات يعمل تبديل لداتا كلها وبعد كده يحفظها
    // OnConflict strategy constant to replace the old data and continue the transaction.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save_Movie(movielist:List<Movie>)
    @Query("DELETE FROM popular_movie")
    suspend fun delete_Movies()
     @Query("SELECT * FROM popular_movie")
    suspend fun getMovies():List<Movie>

}