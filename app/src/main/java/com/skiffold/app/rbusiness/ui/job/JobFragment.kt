package com.skiffold.app.rbusiness.ui.job

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentJobBinding
import com.skiffold.app.rbusiness.ui.utils.DataGame

class JobFragment : Fragment() {
    private lateinit var binding: FragmentJobBinding
    private lateinit var adapter: AdapterJob
    private var dataSelectedJobs = DataGame.DATA_JOBS
    private var selectPos: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        adapter.list.submitList(dataSelectedJobs)
    }

    private fun initAdapter() {
        adapter = AdapterJob{ click -> clickJob(click)}
        binding.rvJob.adapter = adapter
    }

    private fun clickJob(select: Int){
        dataSelectedJobs.forEachIndexed { index, jobModel ->
            jobModel.selected = index == select
        }
        adapter.list.submitList(dataSelectedJobs)
        adapter.notifyItemChanged(selectPos)
        selectPos = select
    }
}