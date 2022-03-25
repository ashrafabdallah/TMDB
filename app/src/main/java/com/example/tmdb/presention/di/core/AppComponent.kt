package com.example.tmdb.presention.di.core

import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.di.movie.MovieSubComponent
import com.example.tmdb.presention.di.tv_show.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        CacheDataBaseModule::class,
        DataBaseModule::class,
        LocalDataBaseModule::class,
        NetModule::class,
        RemoteDataModul::class,
        ReposatoryModule::class,
        UseCaseModule::class]
)
interface AppComponent {
    fun getMovieSubComponent():MovieSubComponent.Factory
    fun getTvShowSubComponent():TvShowSubComponent.Factory
    fun getArtistSubComponent():ArtistSubComponent.Factory
}