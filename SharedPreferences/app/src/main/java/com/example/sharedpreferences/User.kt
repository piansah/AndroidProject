package com.example.sharedpreferences

data class User(
    val id: Int = -1,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val phoneNumber: String
    // Tambahkan properti untuk tanggal lahir
)
