package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    lateinit var sharedPrefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)
    }
}
