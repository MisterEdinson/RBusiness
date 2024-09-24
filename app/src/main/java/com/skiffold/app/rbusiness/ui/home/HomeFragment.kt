package com.skiffold.app.rbusiness.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentHomeBinding
import com.skiffold.app.rbusiness.ui.utils.Stopwatch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var timer: Stopwatch
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        timer = Stopwatch()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer.start()

        binding.apply {
            timer.onTick = {
                txtDate.text = it
            }
        }
    }
}