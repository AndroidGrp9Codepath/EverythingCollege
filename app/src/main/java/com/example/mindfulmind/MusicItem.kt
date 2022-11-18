package com.example.mindfulmind

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class MusicItem (

    @SerialName("name")
    val artistsName: String? = null

): java.io.Serializable