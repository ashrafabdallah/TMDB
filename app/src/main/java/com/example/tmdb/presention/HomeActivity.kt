package com.example.tmdb.presention

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityHomeBinding
import com.example.tmdb.presention.artist.ArtistActivity
import com.example.tmdb.presention.movie.MovieActivity
import com.example.tmdb.presention.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var bindin:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      bindin=DataBindingUtil.setContentView(this,R.layout.activity_home)
        bindin.btnmovie.setOnClickListener {
            startActivity(Intent(this,MovieActivity::class.java))

        }
        bindin.btnartist.setOnClickListener {
            startActivity(Intent(this,ArtistActivity::class.java))
        }
        bindin.btntv.setOnClickListener {
            startActivity(Intent(this,TvShowActivity::class.java))

        }
    }
}