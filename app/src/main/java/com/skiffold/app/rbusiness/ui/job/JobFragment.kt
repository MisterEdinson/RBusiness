package com.skiffold.app.rbusiness.ui.job

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.skiffold.app.rbusiness.R
import com.skiffold.app.rbusiness.databinding.FragmentJobBinding
import com.skiffold.app.rbusiness.ui.dialogs.JobDialog
import com.skiffold.app.rbusiness.ui.home.GameViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame

class JobFragment : Fragment() {
    private lateinit var binding: FragmentJobBinding
    private val viewModel: GameViewModel by activityViewModels()
    private lateinit var adapter: AdapterJob
    private lateinit var dialog : JobDialog
    private var experience = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = JobDialog(binding.root.context)
        initAdapter()
        initListener()
    }

    private fun initListener() {
        viewModel.experience.observe(viewLifecycleOwner){
            experience = it
        }
    }

    private fun initAdapter() {
        adapter = AdapterJob{ click -> clickJob(click)}
        binding.rvJob.adapter = adapter
        adapter.list.submitList(viewModel.dataSelectedJobs)
    }

    private fun clickJob(select: Int){
        val exp = viewModel.dataSelectedJobs[select].experience - experience
        if(exp > 0){
            adapter.list.submitList(viewModel.dataSelectedJobs)
            adapter.notifyDataSetChanged()
            dialog.showDialog(
                "Вам отказали...",
                "Вас не приняли на собеседование изза внешнего вида, Вы очень расстроились и начали ругаться с руководителями. Они вызвали полицию и вам сломали руку. Скорая взяла с Вас 15\$ \n\n Вам не хватило $exp опыта.",
                "Понятно",
                { viewModel.balance.value = viewModel.balance.value?.minus(15) }
            )
        }else{
            viewModel.dataSelectedJobs.forEachIndexed { index, jobModel ->
                jobModel.selected = index == select
            }
            adapter.list.submitList(viewModel.dataSelectedJobs)
            adapter.notifyItemChanged(viewModel.job.value!!)
            viewModel.job.value = select
            dialog.showDialog(
                "Вас взяли на работу!",
                "Вы пришли на собеседование, все прошло хорошо, руководители остались довольны Вами. Выйдя на улицу радость переполняла. На радостях Вы выпили бутылку пива за 2$",
                "Супер",
                { viewModel.balance.value = viewModel.balance.value?.minus(2) }
            )
        }
    }
}