package com.example.hungerwoosh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.CartAdapter
import com.example.hungerwoosh.databinding.FragmentCartBinding
import com.example.hungerwoosh.model.CartItem

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var cartItems: ArrayList<CartItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartItems.add(CartItem("Burger", "$5", R.drawable.burger))
        cartItems.add(CartItem("Sandwich", "$7", R.drawable.sanwich))
        cartItems.add(CartItem("Momo", "$8", R.drawable.momo))
        cartItems.add(CartItem("Fries", "$10", R.drawable.fries))
        val adapter = CartAdapter(cartItems)
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
    }

}