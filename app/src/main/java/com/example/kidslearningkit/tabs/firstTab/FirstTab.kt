package com.example.kidslearningkit.tabs.firstTab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.tabs.secondTab.SecondTab
import com.example.kidslearningkit.tabs.firstTab.screens.*
import com.example.kidslearningkit.tabs.firstTab.screens.alphabates.AlphabateActivity
import kotlinx.android.synthetic.main.activity_main.*

class FirstTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_Slide_Button.setOnClickListener { startActivity(Intent(this , SecondTab :: class.java)) }

        numbers_card.setOnClickListener { startActivity(Intent(this , NumbersActivity :: class.java)) }

        alphabate_card.setOnClickListener { startActivity(Intent(this , AlphabateActivity :: class.java)) }

        animal_card.setOnClickListener { startActivity(Intent(this , AnimalsActivity :: class.java)) }

        fruit_card.setOnClickListener { startActivity(Intent(this , FruitsActivity :: class.java)) }

        shape_card.setOnClickListener { startActivity(Intent(this , ShapesActivity :: class.java)) }

        vehicle_card.setOnClickListener { startActivity(Intent(this , VehiclesActivity :: class.java)) }

    }


}