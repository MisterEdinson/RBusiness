package com.skiffold.app.rbusiness.ui.partJob

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skiffold.app.rbusiness.databinding.ItemProductBinding
import com.skiffold.app.rbusiness.ui.utils.DataGame

class AdapterPartJob(var click: (id:Int) -> Unit) : RecyclerView.Adapter<AdapterPartJob.Holder>() {
    class Holder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<DataGame.ProductModel>() {
        override fun areItemsTheSame(oldItem: DataGame.ProductModel, newItem: DataGame.ProductModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataGame.ProductModel, newItem: DataGame.ProductModel): Boolean {
            return oldItem.moneyMax == newItem.moneyMax && oldItem.moneyMin == newItem.moneyMin
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list.currentList[position]
        holder.binding.apply {
            titleProduct.text = item.name
        }
    }
}