package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sharedpreferences.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        val username = sharedPrefs.getString("user_name", "")
        val email = sharedPrefs.getString("user_email", "")

        binding.textUsername.text = username
        binding.emailProfile.text = email

        // You can continue accessing and setting other views and data in the profile activity

    }
}
