package com.skiffold.app.rbusiness.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentShopBinding
import com.skiffold.app.rbusiness.ui.home.GameViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame

class ShopFragment : Fragment() {
    
    private lateinit var binding: FragmentShopBinding
    private lateinit var adapterShop: AdapterShop
    private val viewModel: GameViewModel by activityViewModels()
    private var data = listOf<DataGame.MarketModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        data = viewModel.dataShop
        adapterShop = AdapterShop{ click -> selectProduct(click)}
        binding.rvMarket.apply {
            adapter = adapterShop
            adapterShop.list.submitList(data)
        }
    }

    private fun selectProduct(click: Int) {

    }
}