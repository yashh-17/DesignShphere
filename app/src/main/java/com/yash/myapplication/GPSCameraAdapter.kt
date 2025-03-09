package com.yash.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yash.myapplication.databinding.ItemGpsCameraBinding

class GPSCameraAdapter(private val dataList: List<String>) :
    RecyclerView.Adapter<GPSCameraAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemGpsCameraBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvData: TextView = binding.tvData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGpsCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvData.text = dataList[position]
    }

    override fun getItemCount(): Int = dataList.size
}
