package com.skiffold.app.rbusiness.data.network

import retrofit2.http.GET

interface SimpleRetrofit {
    @GET("all")
    suspend fun getAll(): String
}