package com.example.myproject.Package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R

class DatesAdapter(private val dates: List<String>) :
    RecyclerView.Adapter<DatesAdapter.DateViewHolder>() {

    class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return DateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val currentDate = dates[position]
        holder.dateTextView.text = currentDate
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}