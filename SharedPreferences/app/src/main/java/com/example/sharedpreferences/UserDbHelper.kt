package com.example.sharedpreferences

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "db_user"
        private const val DATABASE_VERSION = 1

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${UserContract.UserEntry.TABLE_NAME} (" +
                    "${UserContract.UserEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${UserContract.UserEntry.COLUMN_EMAIL} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_USERNAME} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_FIRSTNAME} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_LASTNAME} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_ADDRESS} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_DATEOFBIRTH} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_PHONENUMBER} TEXT, " +
                    "${UserContract.UserEntry.COLUMN_PASSWORD} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserContract.UserEntry.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertData(user: User) {
        val db = writableDatabase
        val sql = "INSERT INTO ${UserContract.UserEntry.TABLE_NAME} " +
                "(${UserContract.UserEntry.COLUMN_EMAIL}, " +
                "${UserContract.UserEntry.COLUMN_USERNAME}, " +
                "${UserContract.UserEntry.COLUMN_FIRSTNAME}, " +
                "${UserContract.UserEntry.COLUMN_LASTNAME}, " +
                "${UserContract.UserEntry.COLUMN_DATEOFBIRTH}, " +
                "${UserContract.UserEntry.COLUMN_PHONENUMBER}, " +
                "${UserContract.UserEntry.COLUMN_PASSWORD}, " +
                "${UserContract.UserEntry.COLUMN_ADDRESS}) " +
                "VALUES ('${user.email}', '${user.userName}', '${user.firstName}', '${user.lastName}', '${user.dateOfBirth}', '${user.phoneNumber}', '${user.password}', '${user.address}')"

        db.execSQL(sql)
        db.close()
    }

    fun getUser(email: String, password: String): User? {
        val db = readableDatabase
        val sql = "SELECT * FROM ${UserContract.UserEntry.TABLE_NAME} WHERE " +
                "${UserContract.UserEntry.COLUMN_EMAIL} = ? AND " +
                "${UserContract.UserEntry.COLUMN_PASSWORD} = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.rawQuery(sql, selectionArgs)

        var user: User? = null

        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_ID))
            val retrievedEmail = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_EMAIL))
            val retrievedUsername = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_USERNAME))
            val firstName = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_FIRSTNAME))
            val lastName = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_LASTNAME))
            val address = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_ADDRESS))
            val dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_DATEOFBIRTH))
            val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PHONENUMBER))
            val retrievedPassword = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PASSWORD))

            user = User(id, retrievedEmail, retrievedUsername, firstName, lastName, address, dateOfBirth, phoneNumber, retrievedPassword)
        }

        cursor.close()
        db.close()
        return user
    }
}
