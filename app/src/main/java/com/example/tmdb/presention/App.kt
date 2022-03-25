package com.example.tmdb.presention

import android.app.Application
import android.os.Build
import com.example.tmdb.BuildConfig
import com.example.tmdb.presention.di.Injector
import com.example.tmdb.presention.di.artist.ArtistSubComponent
import com.example.tmdb.presention.di.core.*
import com.example.tmdb.presention.di.movie.MovieSubComponent
import com.example.tmdb.presention.di.tv_show.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.Base_URL))
            .remoteDataModul(RemoteDataModul(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
      return appComponent.getMovieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.getTvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
       return appComponent.getArtistSubComponent().create()
    }
}