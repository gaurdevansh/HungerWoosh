package com.example.hungerwoosh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungerwoosh.R
import com.example.hungerwoosh.adapter.NotificationAdapter
import com.example.hungerwoosh.databinding.FragmentNotificationBottomBinding
import com.example.hungerwoosh.model.NotificationItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding
    private lateinit var notificationList: ArrayList<NotificationItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)
        setUpNotificationRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpNotificationRecyclerView() {
        notificationList = ArrayList()
        notificationList.add(NotificationItem("Your order has been cancelled successfully", R.drawable.ic_sad))
        notificationList.add(NotificationItem("Your order has been picked up by the delivery partner", R.drawable.ic_truck))
        notificationList.add(NotificationItem("Congrats your order is placed", R.drawable.ic_check))
        val adapter = NotificationAdapter(notificationList)
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
    }
}