package com.example.mindfulmind


data class spotifyToken(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)