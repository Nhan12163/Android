package com.example.buoi7_2

import com.example.buoi7_2.Model.Marvel
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

interface Api {

    @GET("marvel")
//    suspend fun getsuperHeroes(): ResponseBody
    suspend fun getsuperHeroes(): ResponseBody
}