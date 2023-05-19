package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        val userName = sharedPrefs.getString("user_name", "")

        binding.textUsername.text="$userName"

        binding.LayoutDiagnosa.setOnClickListener {
            val intent = Intent(this, SystemActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuProfile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                // Add other menu items if needed
                else -> false
            }
        }
    }

}



//loadFragment(HomeActivity())
//bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
//bottomNav.setOnItemSelectedListener { menuItem ->
//    when (menuItem.itemId) {
//        R.id.menuHome -> {
//            loadFragment(HomeActivity())
//            true
//        }
//        R.id.menuProfile -> {
//            loadFragment(ProfileActivity())
//            true
//        }
//        else -> false
//    }
//}
//}
//private fun loadFragment(fragment: Fragment) {
//    supportFragmentManager.beginTransaction()
//        .replace(R.id.container, fragment)
//        .commit()
//}