package com.example.thigk2

import okhttp3.ResponseBody
import retrofit2.http.GET

interface Api {
    @GET("todos")

    suspend fun getgk():ResponseBody
}