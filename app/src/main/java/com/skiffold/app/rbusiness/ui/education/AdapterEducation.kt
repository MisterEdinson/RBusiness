package com.skiffold.app.rbusiness.ui.education

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skiffold.app.rbusiness.databinding.ItemEducationBinding
import com.skiffold.app.rbusiness.ui.utils.DataGame

class AdapterEducation(var click: (id:Int) -> Unit) : RecyclerView.Adapter<AdapterEducation.Holder>() {
    class Holder(val binding: ItemEducationBinding) : RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<DataGame.JobModel>() {
        override fun areItemsTheSame(oldItem: DataGame.JobModel, newItem: DataGame.JobModel): Boolean {
            return oldItem.selected == newItem.selected
        }

        override fun areContentsTheSame(oldItem: DataGame.JobModel, newItem: DataGame.JobModel): Boolean {
            return oldItem.selected == newItem.selected
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list.currentList[position]
        holder.binding.apply {
            itemCheck.text = "${item.name} - ${item.money} / мес"
            if (item.selected) {
                itemCheck.isChecked = true
            } else {
                itemCheck.isChecked = false
            }
            itemCheck.setOnClickListener {
                click(position)
            }
        }
    }
}