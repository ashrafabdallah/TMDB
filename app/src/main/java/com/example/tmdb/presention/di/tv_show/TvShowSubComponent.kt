package com.example.tmdb.presention.di.tv_show

import com.example.tmdb.presention.artist.ArtistActivity
import com.example.tmdb.presention.di.artist.ArtistModule
import com.example.tmdb.presention.di.artist.ArtistScope
import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.di.movie.MovieModule
import com.example.tmdb.presention.di.movie.MovieScope
import com.example.tmdb.presention.di.movie.MovieSubComponent
import com.example.tmdb.presention.movie.MovieActivity
import com.example.tmdb.presention.tvshow.TvShowActivity
import dagger.Subcomponent
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }

}