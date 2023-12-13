package com.IFAM.PDM.cineticket.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.IFAM.PDM.cineticket.R

class CadastroFragment : Fragment() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)

        val nomeEditText = view.findViewById<EditText>(R.id.nome)
        val sobrenomeEditText = view.findViewById<EditText>(R.id.sobrenome)
        val celularEditText = view.findViewById<EditText>(R.id.celular)
        val emailEditText = view.findViewById<EditText>(R.id.email)
        val senhaEditText = view.findViewById<EditText>(R.id.senha)
        val confirmarSenhaEditText = view.findViewById<EditText>(R.id.confirmar_senha)
        val cadastrarButton = view.findViewById<Button>(R.id.btn_cadastrar)

        cadastrarButton.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val sobrenome = sobrenomeEditText.text.toString()
            val celular = celularEditText.text.toString()
            val email = emailEditText.text.toString()
            val senha = senhaEditText.text.toString()
            val confirmarSenha = confirmarSenhaEditText.text.toString()

            if (nome.isEmpty() || sobrenome.isEmpty() || celular.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (senha != confirmarSenha) {
                Toast.makeText(requireContext(), "As senhas não coincidem", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            requireContext(),
                            "Cadastro bem-sucedido",
                            Toast.LENGTH_SHORT
                        ).show()
                        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Falha no cadastro: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        val registerTextView = view.findViewById<TextView>(R.id.textViewRegister)
        registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
        }

        return view
    }

}