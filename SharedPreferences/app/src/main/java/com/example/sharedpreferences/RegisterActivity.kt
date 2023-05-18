package com.example.sharedpreferences

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterActivity : AppCompatActivity() {
    private lateinit var dbHelper: UserDbHelper
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var inputDateOfBirth: TextInputEditText
    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDbHelper(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        inputDateOfBirth = binding.inputDateOfBirth

        binding.btnRegister.setOnClickListener {
            val firstName = binding.inputFirstName.text.toString()
            val lastName = binding.inputLastName.text.toString()
            val userEmail = binding.inputEmail.text.toString()
            val userDateOfBirth = binding.inputDateOfBirth.text.toString()
            val userPhoneNumber = binding.inputPhoneNumber.text.toString()
            val userPassword = binding.inputPassword.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && userDateOfBirth.isNotEmpty() && userEmail.isNotEmpty() && userPassword.isNotEmpty()) {
                val user = User(firstName = firstName, lastName = lastName, dateOfBirth = userDateOfBirth, phoneNumber = userPhoneNumber, email = userEmail, password = userPassword)
                dbHelper.insertData(user)
                Toast.makeText(this, "Register Berhasil!!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Data Tidak Boleh Kosong!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun showDatePickerDialog(view: View) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            calendar.set(selectedYear, selectedMonth, selectedDay)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val selectedDate = dateFormat.format(calendar.time)
            inputDateOfBirth.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
