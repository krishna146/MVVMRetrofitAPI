package com.example.mvvmretrofitapi.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.api.RetrofitHelper
import com.example.mvvmretrofitapi.api.RetrofitInterface
import com.example.mvvmretrofitapi.application.MyApplication
import com.example.mvvmretrofitapi.databinding.FragmentLoginBinding
import com.example.mvvmretrofitapi.models.LoginData
import com.example.mvvmretrofitapi.models.ServerResponse
import com.example.mvvmretrofitapi.repository.MyRepository
import com.example.mvvmretrofitapi.viewmodel.LoginViewModel
import com.example.mvvmretrofitapi.viewmodel.LoginViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//here we r passing our layout in constructor instead of onCreateView(). it will automatically pass our layout to OnCreateView()
class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _fragmentLoginBinding: FragmentLoginBinding? = null
    private val fragmentLoginBinding
        get() = _fragmentLoginBinding!!
    private lateinit var loginViewModel: LoginViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view binding
        _fragmentLoginBinding = FragmentLoginBinding.bind(view)
        //initializing repository class using our application class
        val myRepository = (activity?.application as MyApplication).myRepository

        //initializing our ViewModel using ViewModelFactory
        loginViewModel =
            ViewModelProvider(
                this,
                LoginViewModelFactory(myRepository)
            )[LoginViewModel::class.java]
        //logging the user
        fragmentLoginBinding.btnLogin.setOnClickListener {
            val email = fragmentLoginBinding.etEmail.text.toString().trim()
            val password = fragmentLoginBinding.etPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "All Fields are Compulsory", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val loginData = LoginData(email, password)
            Log.d("FRAGMENT", loginData.toString())
            GlobalScope.launch {
                loginViewModel.validateUser(loginData)
            }
            var userData: String? = null
            //observing user Response
            loginViewModel.validateApiResponse.observe(requireActivity(), Observer {
                Log.d("UserData", it.user.toString())
                userData = it.user.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(userData!!)
                findNavController().navigate(action)

            })

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentLoginBinding = null
    }

}