package com.example.mvvmretrofitapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitapi.models.ApiResponse
import com.example.mvvmretrofitapi.models.LoginData
import com.example.mvvmretrofitapi.repository.MyRepository
import retrofit2.Call

class LoginViewModel(private val myRepository: MyRepository) : ViewModel() {

    val validateApiResponse: LiveData<Call<ApiResponse>>
        get() = myRepository.validateUserResponse

    //validating User
    suspend fun validateUser(loginData: LoginData) {
        Log.d("InsideView", loginData.toString())
        myRepository.validateUser(loginData)

    }

}