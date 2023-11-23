package com.IFAM.PDM.cineticket.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.IFAM.PDM.cineticket.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
        return view
    }

}