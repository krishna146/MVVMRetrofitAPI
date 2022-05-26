package com.example.mvvmretrofitapi.api

import com.example.mvvmretrofitapi.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//Data Sources
//interface which will interact with our Server
interface RetrofitInterface {

    @POST("/users/signup/")
    suspend fun insertUser(@Body requestBody: SignUpData) : Call<ApiResponse>

    @POST("/users/signin/")
    suspend fun validateUser(@Body loginData: LoginData): Call<ApiResponse>
}