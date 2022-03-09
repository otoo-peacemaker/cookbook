package com.example.googlemap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.googlemap.databinding.FragmentStartRideBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StartRide : BottomSheetDialogFragment() {
    private var _binding: FragmentStartRideBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartRideBinding.inflate(inflater)



        return binding.root
    }

    companion object{
        const val TAG = "StartRide"
    }
}