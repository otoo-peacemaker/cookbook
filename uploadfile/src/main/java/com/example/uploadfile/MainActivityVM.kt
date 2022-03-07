package com.example.uploadfile

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import okhttp3.ResponseBody

class MainActivityVM : ViewModel() {
    private val _imageView = MutableLiveData<ResponseBody>()
    val imageView: LiveData<ResponseBody> get() = _imageView





}