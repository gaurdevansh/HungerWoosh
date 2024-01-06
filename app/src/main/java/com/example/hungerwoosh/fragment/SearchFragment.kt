package com.example.hungerwoosh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.MenuAdapter
import com.example.hungerwoosh.databinding.FragmentSearchBinding
import com.example.hungerwoosh.model.CartItem
import com.example.hungerwoosh.model.MenuItem

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var originalMenuItems: ArrayList<MenuItem>
    private lateinit var adapter: MenuAdapter
    private lateinit var filteredMenuItems : MutableList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateCartItems()
        setUpSearchView()
        showAllMenuItems()
    }

    private fun populateCartItems() {
        filteredMenuItems = ArrayList()
        originalMenuItems = ArrayList()
        originalMenuItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        originalMenuItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        originalMenuItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        originalMenuItems.add(MenuItem("Fries", "$10", R.drawable.fries))
        originalMenuItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        originalMenuItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        originalMenuItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        originalMenuItems.add(MenuItem("Fries", "$10", R.drawable.fries))
        adapter = MenuAdapter(filteredMenuItems)
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText!!)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuItems.clear()
        originalMenuItems.forEachIndexed { index, item ->
            if(item.name.contains(query, ignoreCase = true)) {
                filteredMenuItems.add(item)
            }
        }
        adapter.notifyDataSetChanged()
    }

    private fun showAllMenuItems() {
        filteredMenuItems.clear()
        filteredMenuItems.addAll(originalMenuItems)
        adapter.notifyDataSetChanged()
    }

}