package com.example.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    init {//get notify when this view model is created
        Log.i("GameViewModel","GameViewModel created")
    }

    override fun onCleared() { //To track the life of the view model
        super.onCleared()
        Log.i("GameViewModel","GameViewModel destroyed")

    }
}