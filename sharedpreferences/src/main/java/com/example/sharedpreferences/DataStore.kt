package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class DataStore : AppCompatActivity() {


    fun addData(key: String, value: String, _sharedPref: SharedPreferences) {
        var sharedPref = _sharedPref
        sharedPref = getSharedPreferences("authorization", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getData(key: String? = null, _sharedPref: SharedPreferences) {
        val defaultValue: String? = null
        var sharedPref = _sharedPref
        sharedPref = getSharedPreferences("authorization", Context.MODE_PRIVATE) ?: return
        sharedPref.getString(key, defaultValue)
    }

    fun delData(key: String, value: String) {
        val sharedPref = getSharedPreferences("authorization", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }


}