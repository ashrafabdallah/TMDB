package com.example.tmdb.presention.di.artist

import com.example.tmdb.presention.artist.ArtistActivity
import dagger.Subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }

}