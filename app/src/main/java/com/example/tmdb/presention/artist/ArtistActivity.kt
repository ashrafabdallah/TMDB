package com.example.tmdb.presention.artist

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
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityArtistBinding
import com.example.tmdb.databinding.ActivityMovieBinding
import com.example.tmdb.presention.di.Injector
import com.example.tmdb.presention.movie.MovieViewModel
import com.example.tmdb.presention.movie.MovieViewModelProvider
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelProvider
    private lateinit var artistviewmodel: ArtistViewModel
private lateinit var artistAdapter:ArtistAdapter

    private lateinit var  binding:ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistviewmodel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

      intRecyleView()

    }

    private fun intRecyleView() {
        binding.recArtist.layoutManager=LinearLayoutManager(this)
        artistAdapter=ArtistAdapter()
        binding.recArtist.adapter=artistAdapter
        displayArtist()
    }

    private fun displayArtist() {
        binding.progressBarArtist.visibility= View.VISIBLE
        val response=artistviewmodel.getArtist()
        response.observe(this, Observer {

            if(it!=null)
            {
                artistAdapter.setArtistList(it)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtist.visibility= View.GONE
            }else{
                binding.progressBarArtist.visibility= View.VISIBLE
                Toast.makeText(this,"No Data Display.....",Toast.LENGTH_LONG).show()
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
                UpdateArtist()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }

        }
        // return super.onOptionsItemSelected(item)
    }

    private fun UpdateArtist() {
        binding.progressBarArtist.visibility= View.VISIBLE
        val response= artistviewmodel.updateArtist()
        response.observe(this, Observer {
            if(it!=null)
            {
                artistAdapter.setArtistList(it)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtist.visibility= View.GONE
            }else{
                binding.progressBarArtist.visibility= View.VISIBLE
                Toast.makeText(this,"No Update Data Display.....",Toast.LENGTH_LONG).show()
            }
        })
    }
}