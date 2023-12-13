package com.ifam.pdm.cineticket.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ifam.pdm.cineticket.R
import com.ifam.pdm.cineticket.view.fragments.CinemasFragment
import com.ifam.pdm.cineticket.view.fragments.ConfigsFragment
import com.ifam.pdm.cineticket.view.fragments.HomeFragment
import com.ifam.pdm.cineticket.view.fragments.LoginFragment
import com.ifam.pdm.cineticket.view.fragments.OnLoginStatusChangeListener
import com.ifam.pdm.cineticket.view.fragments.TicketsFragment

class MainActivity : AppCompatActivity(), OnLoginStatusChangeListener {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.cinemas -> {
                    replaceFragment(CinemasFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.ticket -> {
                    replaceFragment(TicketsFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.config -> {
                    replaceFragment(ConfigsFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.loginFragment -> {
                    replaceFragment(LoginFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Verifica se o usuário já está autenticado
        if (isUserLoggedIn()) {
            replaceFragment(HomeFragment())
            showBottomNavigation()
        } else {
            // Se o usuário não está autenticado, exibe o fragmento de login
            replaceFragment(LoginFragment())
            hideBottomNavigation()
        }

        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? LoginFragment)?.loginStatusChangeListener = this
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun replaceFragment(fragment: Fragment) {
        val navController = findNavController(R.id.nav_host_fragment)

        // Use o ID do destino diretamente
        val destinationId = when (fragment) {
            is HomeFragment -> R.id.homeFragment
            is CinemasFragment -> R.id.cinemasFragment
            is TicketsFragment -> R.id.ticketsFragment
            is ConfigsFragment -> R.id.configsFragment
            is LoginFragment -> R.id.loginFragment
            else -> throw IllegalArgumentException("ID de destino não definido para o fragmento: $fragment")
        }

        // Navegar para o destino
        navController.navigate(destinationId)
    }

    override fun onLoginStatusChanged(isLoggedIn: Boolean) {
        if (isLoggedIn) {
            showBottomNavigation()
        } else {
            hideBottomNavigation()
        }
    }


    private fun hideBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.GONE
    }

    private fun showBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.VISIBLE
    }


}