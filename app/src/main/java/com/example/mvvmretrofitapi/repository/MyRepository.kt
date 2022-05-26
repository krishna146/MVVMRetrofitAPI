package com.example.mvvmretrofitapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitapi.api.RetrofitInterface
import com.example.mvvmretrofitapi.models.*

class MyRepository(private val myApi: RetrofitInterface) {

    //LiveData For API APIResponse
    private val responseLiveData = MutableLiveData<ApiResponse>()
    val response: LiveData<ApiResponse>
        get() = responseLiveData //defining getter property for quotes
    private val validateUserResponseLiveData = MutableLiveData<ApiResponse>()
    val validateUserResponse: LiveData<ApiResponse>
        get() = validateUserResponseLiveData //defining getter property for quotes

    //inserting user into our mongoDB
    suspend fun insertUser(signUpData: SignUpData) {
        val apiResponse = myApi.insertUser(signUpData)
        responseLiveData.postValue(apiResponse.body())


    }
   //validating user from mongoDB
    suspend fun validateUser(loginData: LoginData) {
        //getting response from server
        val validationApiResponse = myApi.validateUser(loginData)
        //posting into our live data
        validateUserResponseLiveData.postValue(validationApiResponse.body())


    }
}