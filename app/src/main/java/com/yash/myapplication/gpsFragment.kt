package com.yash.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yash.myapplication.databinding.FragmentGpsBinding

class GPSFragment : Fragment() {

    private var _binding: FragmentGpsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGpsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFetchGPS.setOnClickListener {
            // Ensure visibility before setting text
            binding.tvLatitude.visibility = View.VISIBLE
            binding.tvLongitude.visibility = View.VISIBLE

            // ✅ Update Latitude and Longitude Separately
            binding.tvLatitude.text = "Latitude: 17.3850"
            binding.tvLongitude.text = "Longitude: 78.4867"
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
