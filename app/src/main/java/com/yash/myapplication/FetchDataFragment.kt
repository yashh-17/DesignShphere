package com.yash.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FetchDataFragment : Fragment(R.layout.fragment_fetch_data) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnFetch: Button = view.findViewById(R.id.btnFetchData)
        val textView: TextView = view.findViewById(R.id.textViewData)

        btnFetch.setOnClickListener {
            textView.text = "Data Fetched Successfully!"
        }
    }
}
