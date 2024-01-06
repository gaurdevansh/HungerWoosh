package com.example.hungerwoosh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.BuyAgainAdapter
import com.example.hungerwoosh.adapter.CartAdapter
import com.example.hungerwoosh.databinding.FragmentHistoryBinding
import com.example.hungerwoosh.model.CartItem
import com.example.hungerwoosh.model.MenuItem

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: BuyAgainAdapter
    private lateinit var buyAgainItems: MutableList<MenuItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerview()
    }

    private fun setUpRecyclerview() {
        buyAgainItems = ArrayList()
        buyAgainItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        buyAgainItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        buyAgainItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        buyAgainItems.add(MenuItem("Fries", "$10", R.drawable.fries))

        val adapter = BuyAgainAdapter(buyAgainItems)
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.buyAgainRecyclerView.adapter = adapter
    }

}