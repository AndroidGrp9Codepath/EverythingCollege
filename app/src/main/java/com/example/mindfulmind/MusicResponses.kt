package com.example.mindfulmind

import android.graphics.Movie
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName


class MusicResponses() {
    @SerializedName("items")
    var songs: List<MusicItem>? = null
    // initializer block
    init {
        songs = ArrayList()
    }

    fun parseJSON(response: String?): MusicResponses? {
        val gson = GsonBuilder().create()
        return gson.fromJson(
            response,
            MusicResponses::class.java
        )
    }
}