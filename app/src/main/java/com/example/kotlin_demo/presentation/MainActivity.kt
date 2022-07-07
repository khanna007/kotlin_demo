package com.example.kotlin_demo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.kotlin_demo.R
import com.example.kotlin_demo.di.compunent.AppComponent
import com.example.kotlin_demo.di.core.module.AppModule
import com.google.android.material.bottomnavigation.BottomNavigationView



 class MainActivity : AppCompatActivity() {
     lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component= DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build();
        component.inject(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController)

        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }
}