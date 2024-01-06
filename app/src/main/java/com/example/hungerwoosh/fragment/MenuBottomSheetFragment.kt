package com.example.hungerwoosh.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.MenuAdapter
import com.example.hungerwoosh.databinding.FragmentMenuBottomSheetBinding
import com.example.hungerwoosh.model.MenuItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding
    private lateinit var menuItems: ArrayList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMenu()
        binding.backBtn.setOnClickListener {
            dismiss()
        }
    }

    private fun displayMenu() {
        menuItems = ArrayList()
        menuItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        menuItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        menuItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        menuItems.add(MenuItem("Fries", "$10", R.drawable.fries))
        menuItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        menuItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        menuItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        menuItems.add(MenuItem("Fries", "$10", R.drawable.fries))
        val adapter = MenuAdapter(menuItems, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
    }

}