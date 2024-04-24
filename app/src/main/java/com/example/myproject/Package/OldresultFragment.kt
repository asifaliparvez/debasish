package com.example.myproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R
import com.example.myproject.databinding.FragmentHomeBinding
import com.example.myproject.databinding.FragmentOldresultBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Random

class OldresultFragment : Fragment() {

    private lateinit var binding: FragmentOldresultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOldresultBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val datesList = generateRandomDates(20) // Change the number to adjust the number of dates
        val adapter = DatesAdapter(datesList)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    private fun generateRandomDates(numDates: Int): List<String> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        val datesList = mutableListOf<String>()

        for (i in 0 until numDates) {
            calendar.add(Calendar.DAY_OF_YEAR, -Random().nextInt(365)) // Generate random dates within the past year
            datesList.add(dateFormat.format(calendar.time))
        }

        return datesList
    }

}