package com.IFAM.PDM.cineticket

import android.os.Bundle
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
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Se for a primeira vez que a atividade está sendo criada, exibe o fragmento inicial
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, NavHostFragment.create(R.navigation.nav_graph))
//                .commit()
//        }

//        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_container)
//
//        // Configurar o BottomNavigationView
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.page_1 -> {
//                    // Verifica se já está no HomeFragment antes de navegar
//                    if (navController.currentDestination?.id != R.id.homeFragment) {
//                        navController.navigate(R.id.homeFragment)
//                    }
//                    true
//                }
//                R.id.page_2 -> {
//                    navController.navigate(R.id.cinemasFragment)
//                    true
//                }
//                else -> false
//            }
//        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerId, fragment)
            .commit()
    }
}