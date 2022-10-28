package com.example.mindfulmind

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable

 class Quotes {
    @SerializedName("id")
    var rank : String? = null

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("author")
    var author: String? = null

    @SerializedName("url")
    var quoteImageUrl: String? = null

    @SerializedName("media")
    var media: String? = null

    @SerializedName("cat")
    var cat: String? = null
}