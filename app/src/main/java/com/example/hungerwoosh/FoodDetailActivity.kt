package com.example.hungerwoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hungerwoosh.databinding.ActivityFoodDetailBinding

class FoodDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        val foodName = intent.getStringExtra("MenuItemName")
        val foodPoster = intent.getIntExtra("MenuItemImage", 0)
        binding.foodName.text = foodName
        binding.foodPoster.setImageResource(foodPoster)
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.addToCartBtn.setOnClickListener {
            
        }
    }
}