package com.example.myproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproject.R
import com.example.myproject.databinding.FragmentBarchartBinding
import com.github.mikephil.charting.charts.BarChart


class barchartFragment : Fragment() {
    private lateinit var barchart: BarChart
    private lateinit var binding: FragmentBarchartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_barchart, container, false)
    }


}