package com.example.mindfulmind

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Keep
//@Serializable
// class Quotes {
//    @SerializedName("id")
//    var ids : String? = null
//
//   @SerializedName("text")
//   var quoteMesseges : String? = null
//
//    @JvmField
//    @SerializedName("title")
//    var title: String? = null
//
//   @JvmField
//    @SerializedName("author")
//    var author: String? = null
//
//    @SerializedName("url")
//    var quoteImageUrl: String? = null
//
//    @SerializedName("media")
//    var media: String? = null
//
//    @SerializedName("cat")
//    var cat: String? = null
//}
//@Keep
//@Serializable
//data class SearchResponse(
//    @SerialName("results")
//    val response: BaseResponse?
//)
//@Keep
//@Serializable
//data class BaseResponse(
//    @SerialName("result")
//    val result: List<Quotes>?
//)

@Keep
@Serializable
data class Quotes(
    @SerialName("author")
    val author: String?,
    @SerialName("content")
    val content: String?,
) : java.io.Serializable