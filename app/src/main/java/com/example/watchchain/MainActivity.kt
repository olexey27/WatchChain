package com.example.watchchain

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.watchchain.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    // hier wird das binding deklariert
    private lateinit var binding: ActivityMainBinding

    // Hier wird der Navigation Controller des gesamten Projektes deklariert
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // Die Navigationsleiste am unteren Bildschirmrand wird eingerichtet
        val navView: BottomNavigationView = binding.bottomNavigation

        // Hier wird der Nav Controller zugewiesen und die Action Bar damit eingerichtet
        navController = findNavController(R.id.navFragment)

        // Richtet die Navigation Bar ein, sodass sie mit dem Nav Controller verknüpft ist
        navView.setupWithNavController(navController)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }
    fun hidebottomBar() {
        binding.bottomNavigation.visibility = View.GONE
    }

    fun showBottomBar() {

        binding.bottomNavigation.visibility = View.VISIBLE
    }
}