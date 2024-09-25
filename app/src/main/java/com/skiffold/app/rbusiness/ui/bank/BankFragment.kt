package com.skiffold.app.rbusiness.ui.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentBankBinding

class BankFragment : Fragment() {
    private lateinit var binding: FragmentBankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBankBinding.inflate(layoutInflater)
        return binding.root
    }
}