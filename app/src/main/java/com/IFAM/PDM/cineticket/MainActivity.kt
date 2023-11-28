package com.IFAM.PDM.cineticket

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.IFAM.PDM.cineticket.Fragments.LoginFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.IFAM.PDM.cineticket.Fragments.CinemasFragment
import com.IFAM.PDM.cineticket.Fragments.ConfigsFragment
import com.IFAM.PDM.cineticket.Fragments.HomeFragment
import com.IFAM.PDM.cineticket.Fragments.TicketsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentContainerId = R.id.fragment_container

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
                    hideBottomNavigation()
                    replaceFragment(LoginFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Verifica se o usuário já está autenticado
        if (isUserLoggedIn()) {
            replaceFragment(HomeFragment())
        } else {
            // Se o usuário não está autenticado, exibe o fragmento de login
            replaceFragment(LoginFragment())
        }

    }
    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerId, fragment)
            .commit()
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