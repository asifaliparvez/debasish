package com.example.myproject.Package

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myproject.R
import com.example.myproject.databinding.FragmentSplashsreenBinding

class SplashsreenFragment : Fragment() {
    private lateinit var Navcontrol : NavController
    private lateinit var binding: FragmentSplashsreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment'
        binding = FragmentSplashsreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Navcontrol=Navigation.findNavController(view)
    }
  val handler = Handler(Looper.myLooper()!!).postDelayed(Runnable {
Navcontrol.navigate(R.id.action_splashsreenFragment_to_homeFragment)
  },2000)
}