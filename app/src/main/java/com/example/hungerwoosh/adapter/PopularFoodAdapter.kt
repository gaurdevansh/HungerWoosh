package com.example.hungerwoosh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungerwoosh.adapter.PopularFoodAdapter.PopularFoodViewHolder
import com.example.hungerwoosh.databinding.PopularItemBinding

class PopularFoodAdapter (private val items: List<String>, private val image: List<Int>, private val price: List<String>) : RecyclerView.Adapter<PopularFoodViewHolder>() {

    class PopularFoodViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imageView = binding.foodPoster
        fun bind(item: String, images: Int, prices: String) {
            binding.foodName.text = item
            binding.price.text = prices
            imageView.setImageResource(images)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodViewHolder {
        return PopularFoodViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularFoodViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val prices = price[position]
        holder.bind(item, images, prices)
    }
}