package com.yash.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CameraFragment : Fragment(R.layout.fragment_camera) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCamera: Button = view.findViewById(R.id.btnCamera)
        val textViewMessage: TextView = view.findViewById(R.id.textViewMessage)

        btnCamera.setOnClickListener {
            textViewMessage.text = "Opened the camera"
        }
    }
}
