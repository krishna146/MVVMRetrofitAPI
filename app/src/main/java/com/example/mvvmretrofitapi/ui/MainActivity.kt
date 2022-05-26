package com.example.mvvmretrofitapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.databinding.ActivityLoginBinding
import com.example.mvvmretrofitapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view banding
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        if (intent != null) {
            //getting data from intent
            val userData = intent.getStringExtra("UserData")
            if(userData == null){
                Log.d("IAMNULL", "NULLLLLL")
            }
//            activityMainBinding.txtUserResponse.text = userData
        }
    }
}