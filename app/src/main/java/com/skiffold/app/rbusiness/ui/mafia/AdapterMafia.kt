package com.skiffold.app.rbusiness.ui.mafia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skiffold.app.rbusiness.databinding.ItemMafiaBinding
import com.skiffold.app.rbusiness.ui.utils.DataGame

class AdapterMafia: RecyclerView.Adapter<AdapterMafia.Holder>() {
    class Holder(val binding: ItemMafiaBinding) : RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<DataGame.AvtoritetModel>() {
        override fun areItemsTheSame(oldItem: DataGame.AvtoritetModel, newItem: DataGame.AvtoritetModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataGame.AvtoritetModel, newItem: DataGame.AvtoritetModel): Boolean {
            return oldItem.moneyPercent == newItem.moneyPercent && oldItem.autoritet == newItem.autoritet
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMafiaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = list.currentList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list.currentList[position]
        holder.binding.apply {
            txtNameAutoritet.text = item.name
            txtStatusAutoritet.text = item.status
            txtNickAutoritet.text = item.nick
        }
    }
}