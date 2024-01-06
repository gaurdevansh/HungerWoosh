package com.example.hungerwoosh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungerwoosh.adapter.CartAdapter.*
import com.example.hungerwoosh.databinding.CartItemBinding
import com.example.hungerwoosh.model.CartItem

class CartAdapter(private val cartItems: MutableList<CartItem>) : RecyclerView.Adapter<CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = cartItems[position].name
                cartItemPrice.text = cartItems[position].price
                foodPoster.setImageResource(cartItems[position].image)
                tvQuanity.text = quantity.toString()
                decreaseBtn.setOnClickListener {
                    if(itemQuantities[position] > 1) {
                        itemQuantities[position]--
                        tvQuanity.text = itemQuantities[position].toString()
                    }
                }
                addBtn.setOnClickListener {
                    if(itemQuantities[position] < 10) {
                        itemQuantities[position]++
                        tvQuanity.text = itemQuantities[position].toString()
                    }
                }
                removeBtn.setOnClickListener {
                    if(adapterPosition != RecyclerView.NO_POSITION) {
                        cartItems.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, cartItems.size)
                    }
                }
            }
        }
    }
}