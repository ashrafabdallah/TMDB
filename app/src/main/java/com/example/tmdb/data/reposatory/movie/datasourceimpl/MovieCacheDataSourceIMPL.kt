package com.example.tmdb.data.reposatory.movie.datasourceimpl

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.reposatory.movie.datasource.MovieCachDataSourse

class MovieCacheDataSourceIMPL : MovieCachDataSourse {
    private var movieListcache = ArrayList<Movie>()

    override suspend fun getMoviesFromCach(): List<Movie> {
        return movieListcache
    }

    override suspend fun saveMovieToCach(movielist: List<Movie>) {
        movieListcache.clear()
        movieListcache= ArrayList(movielist)
    }
}