package com.example.bui7

import com.example.bui7.Model.Student
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentApi {
    @GET("display.php")
    suspend fun getStudents(): ResponseBody

//    @FormUrlEncoded
//    @POST("add.php")
//    suspend fun getInsert(@Field("name") name: String,
//                          @Field("email") email: String,
//                          @Field("phone") phone: String): ResponseBody
    @POST ("search.php")
    suspend fun getSearch(@Body student:Student): ResponseBody

    @POST("add.php")
    suspend fun getInsert(@Body student:Student)

    @POST("update.php")
    suspend fun getUpdate(@Body student:Student)
    @POST("delete.php")
    suspend fun getDelete(@Body student:Student)

}
