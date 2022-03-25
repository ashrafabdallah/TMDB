package com.example.tmdb.presention.di

import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.di.movie.MovieSubComponent
import com.example.tmdb.presention.di.tv_show.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}