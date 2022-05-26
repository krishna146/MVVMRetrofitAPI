package com.example.mvvmretrofitapi.models

data class ApiResponse(
    val token: String,
    val user: ServerResponse
)