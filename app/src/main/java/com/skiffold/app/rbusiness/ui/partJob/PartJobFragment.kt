package com.skiffold.app.rbusiness.ui.partJob

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentJobBinding
import com.skiffold.app.rbusiness.databinding.FragmentPartJobBinding
import com.skiffold.app.rbusiness.ui.home.GameViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame

class PartJobFragment : Fragment() {
    private lateinit var binding: FragmentPartJobBinding
    private lateinit var adapterPart: AdapterPartJob
    private val viewModel: GameViewModel by activityViewModels()
    private var data = listOf<DataGame.ProductModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPartJobBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        data = viewModel.dataProducts
        adapterPart = AdapterPartJob{ click -> sale(click)}
        binding.rvPartJob.apply {
            adapter = adapterPart
            adapterPart.list.submitList(data)
        }
    }

    private fun sale(click: Int) {

    }
}