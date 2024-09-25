package com.skiffold.app.rbusiness.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentShopBinding

class ShopFragment : Fragment() {
    
    private lateinit var binding: FragmentShopBinding
    private lateinit var adapterShop: AdapterShop
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
        adapterShop = AdapterShop{ click -> selectProduct(click)}
        binding.rvMarket.adapter = adapterShop
    }

    private fun selectProduct(click: Int) {

    }
}