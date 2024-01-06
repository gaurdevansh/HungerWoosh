package com.example.hungerwoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hungerwoosh.databinding.ActivityPayOutBinding
import com.example.hungerwoosh.fragment.CongratsBottomSheetFragment

class PayOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeOrderBtn.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager, "Test")
        }
    }

    fun goBack() {
        finish()
    }
}