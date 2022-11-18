package com.example.mindfulmind

import com.google.firebase.firestore.auth.User
import retrofit2.Call
import retrofit2.http.*


interface YelpAPIEndpointInterface {
    // Request method and URL specified in the annotation
    @GET("businesses/search")
    fun findTherapists(
        @Header("Authorization") authorization: String,
        @Query("term") keyWord: String,
        @Query("location") location: String): Call<Any>

}