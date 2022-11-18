package com.example.mindfulmind

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class MusicItem (

    @SerializedName("name")
    val songName: String? = null

): java.io.Serializable