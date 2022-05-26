package com.example.mvvmretrofitapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapi.repository.MyRepository

class LoginViewModelFactory(private val myRepository: MyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(myRepository) as T
    }
}