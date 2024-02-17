package com.example.testappmaxix.data

import android.content.SharedPreferences
import javax.inject.Inject

class DefaultRepository @Inject constructor(private val sharedPreferences: SharedPreferences):DataInterface{
    override  fun saveName(name: String) {
        sharedPreferences.edit().putString("name", name).apply()
    }

    override  fun saveAge(age: String) {
        sharedPreferences.edit().putString("age", age.toString()).apply()

    }

    override  fun getName(): String {
        return sharedPreferences.getString("name", "") ?: ""
    }

    override  fun getAge(): String {
        return sharedPreferences.getString("age", "") ?: ""
    }
}