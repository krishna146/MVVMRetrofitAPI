package com.example.mvvmretrofitapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapi.application.MyApplication
import com.example.mvvmretrofitapi.databinding.ActivityLoginBinding
import com.example.mvvmretrofitapi.models.ApiResponse
import com.example.mvvmretrofitapi.models.LoginData
import com.example.mvvmretrofitapi.viewmodel.LoginViewModel
import com.example.mvvmretrofitapi.viewmodel.LoginViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding
        val activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)
        //initializing repository class using our application class
        val myRepository = (application as MyApplication).myRepository
        val intent: Intent? = null
        //initializing ViewModel using our viewModelFactory
        loginViewModel =
            ViewModelProvider(this, LoginViewModelFactory(myRepository))[LoginViewModel::class.java]

        //logging the user
        activityLoginBinding.btnLogin.setOnClickListener {
            val email = activityLoginBinding.etEmail.text.toString().trim()
            val password = activityLoginBinding.etPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All Fields are Compulsory", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val loginData = LoginData(email, password)
            GlobalScope.launch {
                loginViewModel.validateUser(loginData)
            }
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            //observing user Response
            loginViewModel.validateApiResponse.observe(this, Observer {

                it.enqueue(object : Callback<ApiResponse>{
                    override fun onResponse(
                        call: Call<ApiResponse>,
                        response: Response<ApiResponse>
                    ) {
                        Log.d("KRISHNA", response.body().toString())
                    }

                    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                        Log.d("KRISHNA", t.message.toString())
                    }

                })

//                Log.d("UserData", it.user.toString())
//                //sending data to another activity
//                intent!!.putExtra("UserData", it.user.toString())
//                startActivity(intent)

            })

        }

        activityLoginBinding.txtSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onPause() {
        super.onPause()
        finish()
    }

}













