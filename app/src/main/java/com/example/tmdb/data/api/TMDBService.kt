package com.example.tmdb.data.api

import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.model.movie.MoviesList
import com.example.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovie(@Query ("api_key")api_key:String):Response<MoviesList>
    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query ("api_key")api_key:String):Response<TvShowList>
    @GET("person/popular")
    suspend fun getPopularArtist(@Query ("api_key")api_key:String):Response<ArtistList>
}