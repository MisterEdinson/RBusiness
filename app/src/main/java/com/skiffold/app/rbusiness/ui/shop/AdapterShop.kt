package com.skiffold.app.rbusiness.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skiffold.app.rbusiness.databinding.ItemMarketBinding
import com.skiffold.app.rbusiness.ui.utils.DataGame

class AdapterShop(var click: (id:Int) -> Unit) : RecyclerView.Adapter<AdapterShop.Holder>() {
    class Holder(val binding: ItemMarketBinding) : RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<DataGame.MarketModel>() {
        override fun areItemsTheSame(oldItem: DataGame.MarketModel, newItem: DataGame.MarketModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataGame.MarketModel, newItem: DataGame.MarketModel): Boolean {
            return oldItem.money == newItem.money && oldItem.type == newItem.type
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list.currentList[position]
        holder.binding.apply {
            itemMarket.text = "${item.name} - ${item.money} / мес"
            btnMarket.setOnClickListener {
                click(position)
            }
        }
    }
}