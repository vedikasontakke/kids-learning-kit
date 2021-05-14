package com.example.kidslearningkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_Slide_Button.setOnClickListener { startActivity(Intent(this , MainActivity2 :: class.java)) }

        numbers_card.setOnClickListener { startActivity(Intent(this , NumbersActivity :: class.java)) }

        alphabate_card.setOnClickListener { startActivity(Intent(this , AlphabateActivity :: class.java)) }

        animal_card.setOnClickListener { startActivity(Intent(this , AnimalsActivity :: class.java)) }

        fruit_card.setOnClickListener { startActivity(Intent(this , fruitsActivity :: class.java)) }

        shape_card.setOnClickListener { startActivity(Intent(this , ShapesActivity :: class.java)) }

        vehicle_card.setOnClickListener { startActivity(Intent(this , VehiclesActivity :: class.java)) }

    }


}