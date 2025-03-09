package com.yash.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.yash.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_content_main)

        // ✅ Define top-level destinations for navigation
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,              // Home Fragment
                R.id.nav_gallery,           // Gallery Fragment
                R.id.nav_slideshow,         // Slideshow Fragment
                R.id.nav_fetch_by_button,   // Fetch by Button Fragment
                R.id.cameraFragment,        // Camera Fragment
                R.id.nav_gps_camera,        // GPS Camera Fragment
                R.id.nav_gps                // GPS Fragment (if needed)
            ),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // ✅ Set Navigation Item Click Listener
        navView.setNavigationItemSelectedListener(this)
    }

    // ✅ Handle Sidebar Clicks
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> navController.navigate(R.id.nav_home)
            R.id.nav_gallery -> navController.navigate(R.id.nav_gallery)
            R.id.nav_slideshow -> navController.navigate(R.id.nav_slideshow)
            R.id.nav_camera -> navController.navigate(R.id.cameraFragment)
            R.id.nav_gps_camera -> navController.navigate(R.id.nav_gps_camera)
            R.id.nav_fetch_by_button -> navController.navigate(R.id.nav_fetch_by_button)
            R.id.nav_gps -> navController.navigate(R.id.nav_gps)  // Add this line for GPS Fragment
        }
        binding.drawerLayout.closeDrawers()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
