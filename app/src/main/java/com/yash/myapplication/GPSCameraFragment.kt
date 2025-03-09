package com.yash.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.myapplication.databinding.FragmentGpsCameraBinding

class GPSCameraFragment : Fragment() {

    private var _binding: FragmentGpsCameraBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGpsCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dummyData = listOf("Saved Data 1", "Saved Data 2", "Saved Data 3", "Saved Data 4")
        val adapter = GPSCameraAdapter(dummyData)
        binding.recyclerView.adapter = adapter

        // Show TextView when button is clicked
        binding.btnFetchData.setOnClickListener {
            binding.tvSavedData.visibility = View.VISIBLE
            binding.tvSavedData.text = "Saved Data in Database"
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
