package com.example.tmdb.data.reposatory.movie.datasourceimpl

import com.example.tmdb.data.db.DaoMovie
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.reposatory.movie.datasource.MovieLocalDataSourse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceIMPL(private val dao:DaoMovie) : MovieLocalDataSourse {
    override suspend fun getMovieListFromDB(): List<Movie> {
      return dao.getMovies()
    }

    override suspend fun saveMovieListtoDB(movieList: List<Movie>) {
      CoroutineScope(Dispatchers.IO).launch {
          dao.save_Movie(movieList)
      }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {

          dao.delete_Movies()
      }
    }
}