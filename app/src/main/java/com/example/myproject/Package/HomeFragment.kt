package com.example.myproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myproject.R
import com.example.myproject.databinding.FragmentHomeBinding
import com.example.myproject.databinding.FragmentSplashsreenBinding

class HomeFragment : Fragment() {
    private lateinit var Navcontrol : NavController
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerevents()
    }
    private fun registerevents(){
        binding.Morning.setOnClickListener {
            Navcontrol.navigate(R.id.action_homeFragment_to_morningresultFragment)
            binding.old.setOnClickListener {
                Navcontrol.navigate(R.id.action_homeFragment_to_morningoldFragment)
            }
        }
    }
    private fun init(view: View){
Navcontrol = Navigation.findNavController(view)
    }
}