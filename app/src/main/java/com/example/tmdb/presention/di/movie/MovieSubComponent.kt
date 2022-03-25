package com.example.tmdb.presention.di.movie

import com.example.tmdb.presention.artist.ArtistActivity
import com.example.tmdb.presention.di.artist.ArtistModule
import com.example.tmdb.presention.di.artist.ArtistScope
import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.movie.MovieActivity
import dagger.Subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}