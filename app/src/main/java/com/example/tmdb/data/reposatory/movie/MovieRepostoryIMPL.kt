package com.example.tmdb.data.reposatory.movie

import android.util.Log
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.reposatory.movie.datasource.MovieCachDataSourse
import com.example.tmdb.data.reposatory.movie.datasource.MovieLocalDataSourse
import com.example.tmdb.data.reposatory.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.domain.repository.MovieReposatory
import java.lang.Exception

class MovieRepostoryIMPL(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCachDataSourse: MovieCachDataSourse,
    private val movieLocalDataSourse: MovieLocalDataSourse
) : MovieReposatory {
    override suspend fun getMovie(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        var newlistOfmovies: List<Movie> = getMovieFromApi()
        movieLocalDataSourse.clearAll()
        movieLocalDataSourse.saveMovieListtoDB(newlistOfmovies)
        movieCachDataSourse.saveMovieToCach(newlistOfmovies)
        return newlistOfmovies
    }

    suspend fun getMovieFromApi(): List<Movie> {
        lateinit var movielist: List<Movie>
        try {
            var response = movieRemoteDataSource.getMovies()
            var responsebody = response.body()
            if (responsebody != null) {
                movielist = responsebody.movies
            }

        } catch (expextion: Exception) {
            Log.i("Mytag", expextion.message.toString())
        }


        return movielist
    }

    suspend fun getMovieFromLocalDataBase(): List<Movie> {
        lateinit var movielist: List<Movie>
        try {
            movielist = movieLocalDataSourse.getMovieListFromDB()

        } catch (expextion: Exception) {
            Log.i("Mytag", expextion.message.toString())
        }
        if (movielist.size > 0) {
            return movielist
        } else {
            movielist = getMovieFromApi()
            movieLocalDataSourse.saveMovieListtoDB(movielist)
        }

        return movielist
    }

    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movielist: List<Movie>
        try {
            movielist = movieCachDataSourse.getMoviesFromCach()

        } catch (expextion: Exception) {
            Log.i("Mytag", expextion.message.toString())
        }
        if (movielist.size > 0) {
            return movielist
        } else {
            movielist = getMovieFromLocalDataBase()
            movieCachDataSourse.saveMovieToCach(movielist)
        }

        return movielist
    }
}