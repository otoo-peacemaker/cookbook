package com.example.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initiate rating bar and a button
        // initiate rating bar and a button
        val simpleRatingBar: RatingBar = findViewById<View>(R.id.simpleRatingBar) as RatingBar
        val submitButton: Button = findViewById<View>(R.id.submitButton) as Button
        // perform click event on button
        // perform click event on button
        submitButton.setOnClickListener { // get values and then displayed in a toast
            val totalStars = "Total Stars:: " + simpleRatingBar.getNumStars()
            val rating = "Rating :: " + simpleRatingBar.getRating()
            Toast.makeText(
                applicationContext, """
         $totalStars
         $rating
         """.trimIndent(), Toast.LENGTH_LONG
            ).show()
        }

    }
}