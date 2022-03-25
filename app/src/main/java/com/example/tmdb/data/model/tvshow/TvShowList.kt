package com.example.tmdb.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,

    )