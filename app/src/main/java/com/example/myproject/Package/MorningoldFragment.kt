package com.example.myproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.MyAdapter
import com.example.myproject.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MorningoldFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_morningold, container, false)

        recyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = generateDataList()
        adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val firstVisibleItemPosition =
                        (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    val lastVisibleItemPosition =
                        (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    val middlePosition = (firstVisibleItemPosition + lastVisibleItemPosition) / 2
                    adapter.notifyItemChanged(middlePosition)
                }
            }
        })
    }

    private fun generateDataList(): List<Mydata> {
        val dataList = mutableListOf<Mydata>()
        val calendar = Calendar.getInstance()
        // Set the initial date to April 24, 2024
        calendar.set(2024, Calendar.APRIL, 24)
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        for (i in 0 until 100) {
            val date = sdf.format(calendar.time)
            dataList.add(Mydata(date))
            // Increment the date by one day
            calendar.add(Calendar.DATE, 1)
        }
        return dataList
    }
}