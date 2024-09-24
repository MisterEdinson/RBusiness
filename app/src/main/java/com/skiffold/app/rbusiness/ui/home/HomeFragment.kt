package com.skiffold.app.rbusiness.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: GameViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        addListeners()
        viewModel.start()
        binding.apply {

        }
    }

    private fun addListeners() {
        binding.apply {
            btnJob.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_jobFragment) }
            btnEducation.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_educationFragment) }
            btnPartJob.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_partJobFragment) }
            btnShop.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_shopFragment) }
            btnBank.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_bankFragment) }
            btnMafia.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_mafiaFragment) }
        }
    }

    private fun addObservers() {
        binding.apply {
            viewModel.currentDateLiveData.observe(viewLifecycleOwner) { txtDate.text = it }
            viewModel.balance.observe(viewLifecycleOwner) { txtMoney.text = "$it $" }
            viewModel.experience.observe(viewLifecycleOwner) { txtExperience.text = it.toString() }
        }
    }
}