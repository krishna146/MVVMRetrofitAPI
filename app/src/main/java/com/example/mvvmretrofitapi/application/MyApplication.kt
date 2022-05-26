package com.example.mvvmretrofitapi.application

import android.app.Application
import com.example.mvvmretrofitapi.api.RetrofitHelper
import com.example.mvvmretrofitapi.api.RetrofitInterface
import com.example.mvvmretrofitapi.repository.MyRepository

class MyApplication: Application() {
    //since manyView may have need of instance of repository class so we r defining a common repository class
    lateinit var myRepository: MyRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        //Creating Instance of Retrofit i.e. connecting our interface and object -> it will return an interface to our api
        //instance of quoteAPI
        val quoteService = RetrofitHelper.getInstance().create(RetrofitInterface::class.java)
        //initializing instance of repository and instance of repository needs the instance of OurDataSource(API)
        myRepository = MyRepository(quoteService)

    }
}