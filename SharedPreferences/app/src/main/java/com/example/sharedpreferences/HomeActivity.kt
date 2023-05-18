package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        val userId = sharedPrefs.getInt("user_id", -1)
        val userName = sharedPrefs.getString("user_name", "")

        binding.textHello.text = "Hello${userName.toString()}"

        // Handle your other views and logic here
    }
}
