package com.IFAM.PDM.cineticket.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.IFAM.PDM.cineticket.R

class ConfigsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configs, container, false)

        val btnSair = view.findViewById<Button>(R.id.btnSair)
        btnSair.setOnClickListener {
            logout()
        }

        return view
    }

    private fun logout() {
        clearLoginState()
        findNavController().navigate(R.id.loginFragment)
    }

    private fun clearLoginState() {
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()
    }
}
