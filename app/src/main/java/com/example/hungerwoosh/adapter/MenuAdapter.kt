package com.example.hungerwoosh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungerwoosh.FoodDetailActivity
import com.example.hungerwoosh.databinding.MenuItemBinding
import com.example.hungerwoosh.model.MenuItem

class MenuAdapter(private val menuItems: MutableList<MenuItem>, private val context: Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                val intent = Intent(context, com.example.hungerwoosh.FoodDetailActivity::class.java)
                intent.putExtra("MenuItemName",menuItems[position].name )
                intent.putExtra("MenuItemImage", menuItems[position].image)
                context.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                foodName.text = menuItems[position].name
                price.text = menuItems[position].price
                foodPoster.setImageResource(menuItems[position].image)

            }
        }
    }

    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}


