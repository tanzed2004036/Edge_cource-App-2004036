package com.example.myfirstapp.server_communication

import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}