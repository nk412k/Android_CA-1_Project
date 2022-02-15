package com.example.androidca_1project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class RatingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_page)
        setTitle("Rating Page")
        val rb : RatingBar = findViewById(R.id.ratingBar1)
        val rateT : TextView = findViewById(R.id.ratetext)
        val subBtn : Button = findViewById(R.id.btnRateSubmit)

        val rb1 : RatingBar = findViewById(R.id.rate1)
        val rb2 : RatingBar = findViewById(R.id.rate2)
        val rb3 : RatingBar = findViewById(R.id.rate3)
        val rb4 : RatingBar = findViewById(R.id.rate4)


        subBtn.setOnClickListener(){


            var r1 = rb1.rating
            var r2 = rb2.rating
            var r3 = rb3.rating
            var r4 = rb4.rating

            var avg = (r1 + r2 + r3+r4)/4


            rb.rating = avg
            var rating = "Rating :: " + rb.rating
            when(avg.toInt()){
                5  -> {
                    rateT.setText("best")
                }

                4 -> {
                    rateT.setText("good")
                }
                3 -> {
                    rateT.setText("average")
                }
                2 -> {
                    rateT.setText("bad")
                }
                else ->
                    rateT.setText("worst")
            }

           Toast.makeText(this, "$rating", Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed({
                val i= Intent(this,MainActivity::class.java)
                startActivity(i)},1000)

        }



    }
}
