package com.example.hungerwoosh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungerwoosh.FoodDetailActivity
import com.example.hungerwoosh.adapter.PopularFoodAdapter.PopularFoodViewHolder
import com.example.hungerwoosh.databinding.PopularItemBinding
import com.example.hungerwoosh.model.MenuItem

class PopularFoodAdapter (private val popularFoodItems: ArrayList<MenuItem>, private val context: Context) : RecyclerView.Adapter<PopularFoodViewHolder>() {

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
        return popularFoodItems.size
    }

    override fun onBindViewHolder(holder: PopularFoodViewHolder, position: Int) {
        val item = popularFoodItems[position].name
        val image = popularFoodItems[position].image
        val price = popularFoodItems[position].price
        holder.bind(item, image, price)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FoodDetailActivity::class.java)
            intent.putExtra("MenuItemName",item )
            intent.putExtra("MenuItemImage", image)
            context.startActivity(intent)
        }
    }
}