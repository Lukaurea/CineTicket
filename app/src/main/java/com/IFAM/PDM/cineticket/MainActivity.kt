package com.IFAM.PDM.cineticket

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.IFAM.PDM.cineticket.Fragments.LoginFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, NavHostFragment.create(R.navigation.nav_graph))
                .commit()
        }
    }
}