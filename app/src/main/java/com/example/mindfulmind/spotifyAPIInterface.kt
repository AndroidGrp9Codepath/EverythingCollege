package com.example.mindfulmind

import retrofit2.Call
import retrofit2.http.*

interface spotifyAPIInterface{
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api/token")
    fun getToken(@Header("Authorization") auth:String,
                 @Field(("grant_type")) grantType:String,

    ): Call<spotifyToken>
}