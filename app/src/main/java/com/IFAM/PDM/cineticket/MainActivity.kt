package com.IFAM.PDM.cineticket

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.IFAM.PDM.cineticket.Fragments.LoginFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.IFAM.PDM.cineticket.R
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.IFAM.PDM.cineticket.Fragments.CinemasFragment
import com.IFAM.PDM.cineticket.Fragments.ConfigsFragment
import com.IFAM.PDM.cineticket.Fragments.HomeFragment
import com.IFAM.PDM.cineticket.Fragments.OnLoginStatusChangeListener
import com.IFAM.PDM.cineticket.Fragments.TicketsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
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
        Log.d("MainActivity", "BottomNavigation hidden")
    }


    private fun showBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.VISIBLE
    }


}