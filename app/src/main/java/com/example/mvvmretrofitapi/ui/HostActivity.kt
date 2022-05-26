package com.example.mvvmretrofitapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.application.MyApplication
import com.example.mvvmretrofitapi.repository.MyRepository

class HostActivity : AppCompatActivity() {
    private lateinit var myRepository: MyRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

    }
}