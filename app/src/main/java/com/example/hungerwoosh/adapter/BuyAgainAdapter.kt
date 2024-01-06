package com.example.hungerwoosh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungerwoosh.databinding.BuyAgainItemBinding
import com.example.hungerwoosh.databinding.MenuItemBinding
import com.example.hungerwoosh.model.MenuItem

class BuyAgainAdapter(private val menuItems: MutableList<MenuItem>) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class BuyAgainViewHolder(private val binding: BuyAgainItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
               foodName.text = menuItems[position].name
                foodPrice.text = menuItems[position].price
                foodPoster.setImageResource(menuItems[position].image)

            }
        }
    }
}