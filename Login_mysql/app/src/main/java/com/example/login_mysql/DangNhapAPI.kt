package com.example.login_mysql

import com.example.login_mysql.Model.DangNhap
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface DangNhapAPI {

    @POST ("register.php")
    suspend fun Register(@Body dangnhap:DangNhap)

//    @FormUrlEncoded
    @POST ("login.php")
//    suspend fun Login(@Field ("user") user:String,
//                      @Field("pass") pass:String):DangNhap
    suspend fun Login(@Body dangnhap:DangNhap):DangNhap
}