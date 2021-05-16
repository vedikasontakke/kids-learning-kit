package com.example.kidslearningkit.tabs.secondTab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.tabs.secondTab.screens.*
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.PuzzlesActivity
import com.example.kidslearningkit.tabs.firstTab.FirstTab
import kotlinx.android.synthetic.main.activity_main2.*

class SecondTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        left_Slide_Button.setOnClickListener { startActivity(Intent(this , FirstTab :: class.java)) }

        months_card.setOnClickListener { startActivity(Intent(this , MonthsActivity :: class.java)) }

        weeks_card.setOnClickListener { startActivity(Intent(this , WeeksActivity :: class.java)) }

        flags_card.setOnClickListener { startActivity(Intent(this , FlagsActivity :: class.java)) }

        puzzle_card.setOnClickListener { startActivity(Intent(this , PuzzlesActivity :: class.java)) }

        actions_card.setOnClickListener { startActivity(Intent(this , ActionsActivity :: class.java)) }

        body_card.setOnClickListener { startActivity(Intent(this , BodyPartsActivity :: class.java)) }


    }
}