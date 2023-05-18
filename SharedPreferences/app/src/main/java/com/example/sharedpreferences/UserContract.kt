package com.example.sharedpreferences

import android.provider.BaseColumns

object UserContract {
    object UserEntry : BaseColumns {
        const val TABLE_NAME = "user"
        const val COLUMN_ID = "id"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_FIRSTNAME = "firstName"
        const val COLUMN_LASTNAME = "lastName"
        const val COLUMN_DATEOFBIRTH = "dateOfBirth"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_PHONENUMBER = "phone"

    }
}
