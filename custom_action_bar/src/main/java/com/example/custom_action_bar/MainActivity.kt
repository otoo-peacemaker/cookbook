package com.example.custom_action_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.custom_action_bar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //This method sets the toolbar as the app bar for this activity
        setSupportActionBar(binding.topAppBar)

        //navigation drawer icon listener
        binding.topAppBar.setNavigationOnClickListener(View.OnClickListener {
            //later implementation
        })

    }

    //responding to actions when action i selected
    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.fav ->{
            TODO("LATER IMPLEMENTATION")
            true
        }
        R.id.search ->{

            TODO("LATER IMPLEMENTATION")
            true
        }
        R.id.log_out ->{

            TODO("LATER IMPLEMENTATION")
            true
        }


        else -> {
            super.onOptionsItemSelected(item)
        }
    }


}