package com.example.hungerwoosh.fragment

import android.os.Bundle
import android.view.LayoutInflater
import com.example.hungerwoosh.model.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.PopularFoodAdapter
import com.example.hungerwoosh.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var popularFoodItems: ArrayList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayFoodBanner()
        displayPopularFoodItems()
        binding.viewMenuBtn.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "MenuItems")
        }
    }

    private fun displayFoodBanner() {
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener {
            override fun doubleClick(position: Int) {
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayPopularFoodItems() {
        popularFoodItems = ArrayList()
        popularFoodItems.add(MenuItem("Burger", "$5", R.drawable.burger))
        popularFoodItems.add(MenuItem("Sandwich", "$7", R.drawable.sanwich))
        popularFoodItems.add(MenuItem("Momo", "$8", R.drawable.momo))
        popularFoodItems.add(MenuItem("Fries", "$10", R.drawable.fries))
        val adapter = PopularFoodAdapter(popularFoodItems, requireContext())
        binding.popularFoodRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularFoodRecyclerView.adapter = adapter
    }

}