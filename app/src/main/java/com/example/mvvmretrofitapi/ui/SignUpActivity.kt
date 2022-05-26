package com.example.mvvmretrofitapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.application.MyApplication
import com.example.mvvmretrofitapi.databinding.ActivitySignUpBinding
import com.example.mvvmretrofitapi.models.SignUpData
import com.example.mvvmretrofitapi.viewmodel.SignUpViewModel
import com.example.mvvmretrofitapi.viewmodel.SignUpViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpViewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view banding
        val activitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(activitySignUpBinding.root)
        //initializing repository class using our application class
        val myRepository = (application as MyApplication).myRepository

        //initializing our view model using viewmodelfactory
        signUpViewModel =
            ViewModelProvider(
                this,
                SignUpViewModelFactory(myRepository)
            )[SignUpViewModel::class.java]
        //onClick
        activitySignUpBinding.btnRegister.setOnClickListener {
            val name = activitySignUpBinding.etName.text.toString().trim()
            val email = activitySignUpBinding.etEmail.text.toString().trim()
            val password = activitySignUpBinding.etPassword.text.toString().trim()
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All Fields are Compulsory", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = SignUpData(name, email, password)

            GlobalScope.launch {
                signUpViewModel.insertUser(user)
            }

            Toast.makeText(this, "You are Successfully registered :)\n Please Login to Go Further ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)

        }

        //observing user Response
        signUpViewModel.response.observe(this, Observer {
            Log.d("user", it.user.toString())
        })


    }


}