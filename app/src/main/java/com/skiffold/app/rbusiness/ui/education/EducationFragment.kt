package com.skiffold.app.rbusiness.ui.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentEducationBinding
import com.skiffold.app.rbusiness.ui.home.GameViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame

class EducationFragment : Fragment() {
    private lateinit var binding: FragmentEducationBinding
    private lateinit var adapter: AdapterEducation
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEducationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterInit()
    }

    private fun adapterInit() {
        adapter = AdapterEducation{ click -> checked(click) }
        binding.rvEducation.adapter = adapter
        adapter.list.submitList(viewModel.dataSelectedEducation)
    }

    private fun checked(select: Int){
        viewModel.dataSelectedEducation.forEachIndexed { index, jobModel ->
            if(select == index){
                if(jobModel.selected){
                    jobModel.selected = false
                    viewModel.educations.remove(jobModel)
                }else{
                    jobModel.selected = true
                    viewModel.educations.add(jobModel)
                }
            }
        }
    }
}