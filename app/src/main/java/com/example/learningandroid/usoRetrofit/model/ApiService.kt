package com.example.learningandroid.usoRetrofit.model

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("todos/{id}")
    suspend fun getTodo( @Path("id") postId: Int ) : Task
    @GET("todos")
    suspend fun getTodos() : List<Task>
}