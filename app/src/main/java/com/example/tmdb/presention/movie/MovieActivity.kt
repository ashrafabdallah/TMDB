package com.example.tmdb.presention.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityMovieBinding
import com.example.tmdb.presention.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelProvider
    private lateinit var movieviewmodel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter:MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieviewmodel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        intiRecycle()
    }
    fun intiRecycle(){
        binding.recycleMovieView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recycleMovieView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = movieviewmodel.getmovie()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }


        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator:MenuInflater=menuInflater
        inflator.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.btnUpdate->{
                UpdateMovies()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }

        }
       // return super.onOptionsItemSelected(item)
    }

    fun UpdateMovies(){
        binding.progressBar.visibility = View.VISIBLE
        var response=movieviewmodel.updateMovie()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }
            else{
                binding.progressBar.visibility = View.VISIBLE
            }
        })

    }

}