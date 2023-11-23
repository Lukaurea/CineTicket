package com.IFAM.PDM.cineticket.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.IFAM.PDM.cineticket.R
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val entrarButton = view.findViewById<Button>(R.id.btn_entrar)
        entrarButton.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        return view
    }


}