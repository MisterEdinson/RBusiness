package com.skiffold.app.rbusiness.ui.mafia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentMafiaBinding
import com.skiffold.app.rbusiness.ui.home.GameViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame

class MafiaFragment : Fragment() {
    private lateinit var binding: FragmentMafiaBinding
    private lateinit var adapterMafia: AdapterMafia
    private val viewModel: GameViewModel by activityViewModels()
    private var data = listOf<DataGame.AvtoritetModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMafiaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        data = viewModel.dataMafia
        adapterMafia = AdapterMafia()
        binding.rvMafia.apply {
            adapter = adapterMafia
            adapterMafia.list.submitList(data)
        }
    }
}