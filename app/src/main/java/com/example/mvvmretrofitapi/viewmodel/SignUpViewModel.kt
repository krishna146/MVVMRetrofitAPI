package com.example.mvvmretrofitapi.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitapi.models.ApiResponse
import com.example.mvvmretrofitapi.models.SignUpData
import com.example.mvvmretrofitapi.repository.MyRepository

class SignUpViewModel(private val myRepository: MyRepository) : ViewModel() {
    //livedata for our for our api
    val response: LiveData<ApiResponse>
        get() = myRepository.response


    //inserting our user
    suspend fun insertUser(signUpData: SignUpData){
        myRepository.insertUser(signUpData)
    }

}