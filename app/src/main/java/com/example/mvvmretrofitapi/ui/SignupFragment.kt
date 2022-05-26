package com.example.mvvmretrofitapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.databinding.FragmentLoginBinding
import com.example.mvvmretrofitapi.databinding.FragmentSignupBinding

class SignupFragment : Fragment(R.layout.fragment_signup) {
    private var _fragmentSignupBinding: FragmentSignupBinding? = null
    private val fragmentLoginBinding
        get() = _fragmentSignupBinding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentSignupBinding = FragmentSignupBinding.bind(view)

    }

}