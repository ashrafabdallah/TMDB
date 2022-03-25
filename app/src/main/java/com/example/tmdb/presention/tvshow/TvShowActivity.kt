package com.example.tmdb.presention.tvshow

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityTvShowBinding
import com.example.tmdb.presention.di.Injector
import com.example.tmdb.presention.movie.MovieViewModel
import com.example.tmdb.presention.movie.MovieViewModelProvider
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelProvider
    private lateinit var tvShowViewmodel: TvShowViewModel
    private lateinit var tvShowAdapter: TVShowAdapter
    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)


        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewmodel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecycleView()
    }

    fun initRecycleView() {
        binding.reTvshow.layoutManager = LinearLayoutManager(this)
        tvShowAdapter=TVShowAdapter()
        binding.reTvshow.adapter = tvShowAdapter
        displayTvShow()

    }

    private fun displayTvShow() {
        binding.progressBarTvShow.visibility = View.VISIBLE
        val respons = tvShowViewmodel.getTvShow()
        respons.observe(this, Observer {
            if (it != null) {
                binding.progressBarTvShow.visibility = View.GONE
                tvShowAdapter.setTvShowList(it)
                tvShowAdapter.notifyDataSetChanged()

            } else {
                binding.progressBarTvShow.visibility = View.VISIBLE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater:MenuInflater=menuInflater
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.btnUpdate->{
                updateTvShow()
                return true
            }
            else->{
                return super.onOptionsItemSelected(item)
            }
        }



    }

    private fun updateTvShow() {
        binding.progressBarTvShow.visibility=View.VISIBLE
        val response= tvShowViewmodel.updateTvShow()
        response.observe(this, Observer {
            if(it!=null)
            {
                binding.progressBarTvShow.visibility=View.GONE
                tvShowAdapter.setTvShowList(it)
                tvShowAdapter.notifyDataSetChanged()
            }else{
                binding.progressBarTvShow.visibility = View.VISIBLE
                Toast.makeText(applicationContext,"No data available to Update", Toast.LENGTH_LONG).show()
            }

        })
    }
}