package com.example.tmdb.presention.di.core

import android.content.Context
import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.di.movie.MovieSubComponent
import com.example.tmdb.presention.di.tv_show.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,
    TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return context.applicationContext
    }


}