package com.example.kidslearningkit.activites.mainActivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.activites.mainActivity2.MainActivity2
import com.example.kidslearningkit.activites.mainActivty.firstScreen.*
import com.example.kidslearningkit.activites.mainActivty.firstScreen.alphabates.AlphabateActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_Slide_Button.setOnClickListener { startActivity(Intent(this , MainActivity2 :: class.java)) }

        numbers_card.setOnClickListener { startActivity(Intent(this , NumbersActivity :: class.java)) }

        alphabate_card.setOnClickListener { startActivity(Intent(this , AlphabateActivity :: class.java)) }

        animal_card.setOnClickListener { startActivity(Intent(this , AnimalsActivity :: class.java)) }

        fruit_card.setOnClickListener { startActivity(Intent(this , FruitsActivity :: class.java)) }

        shape_card.setOnClickListener { startActivity(Intent(this , ShapesActivity :: class.java)) }

        vehicle_card.setOnClickListener { startActivity(Intent(this , VehiclesActivity :: class.java)) }

    }


}