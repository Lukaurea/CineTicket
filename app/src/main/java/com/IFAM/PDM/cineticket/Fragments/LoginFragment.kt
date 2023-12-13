package com.IFAM.PDM.cineticket.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.IFAM.PDM.cineticket.R
import androidx.navigation.fragment.findNavController

interface OnLoginStatusChangeListener {
    fun onLoginStatusChanged(isLoggedIn: Boolean)
}

class LoginFragment : Fragment() {

    private var loginStatusChangeListener: OnLoginStatusChangeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLoginStatusChangeListener) {
            loginStatusChangeListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val registerTextView = view.findViewById<TextView>(R.id.textViewRegister)
        registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }


        val entrarButton = view.findViewById<Button>(R.id.btn_entrar)
        val emailEditText = view.findViewById<EditText>(R.id.email)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
//        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        entrarButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
//            progressBar.visibility = View.VISIBLE

            if (isValidCredentials(email, password)) {
                saveLoginState(true)
                loginStatusChangeListener?.onLoginStatusChanged(true)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(requireContext(), "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }

//            progressBar.visibility = View.GONE
        }

        return view
    }
    private fun isValidCredentials(email: String, password: String): Boolean {
        val isValid = email == "usuario@example.com" && password == "senha123"

        if (isValid) {
            // Salva o estado de login no SharedPreferences
            saveLoginState(true)
        }

        return isValid
    }

    private fun onLogout() {
        saveLoginState(false)
        loginStatusChangeListener?.onLoginStatusChanged(false)
    }

    private fun saveLoginState(isLoggedIn: Boolean) {
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }


}