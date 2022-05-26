package com.example.mvvmretrofitapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mvvmretrofitapi.R
import com.example.mvvmretrofitapi.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val fragmentHomeBinding
        get() = _fragmentHomeBinding!!

    //creating object for args class

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentHomeBinding = FragmentHomeBinding.bind(view)

    }
}