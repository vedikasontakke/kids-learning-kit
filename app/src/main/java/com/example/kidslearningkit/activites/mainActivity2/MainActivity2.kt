package com.example.kidslearningkit.activites.mainActivity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.activites.mainActivity2.secondScreen.*
import com.example.kidslearningkit.activites.mainActivity2.secondScreen.puzzles.PuzzlesActivity
import com.example.kidslearningkit.activites.mainActivty.MainActivity
import com.example.kidslearningkit.utils.move
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        left_Slide_Button.setOnClickListener { startActivity(Intent(this , MainActivity :: class.java)) }

        months_card.setOnClickListener { startActivity(Intent(this , monthsActivity :: class.java)) }

        weeks_card.setOnClickListener { startActivity(Intent(this , WeeksActivity :: class.java)) }

        flags_card.setOnClickListener { startActivity(Intent(this , FlagsActivity :: class.java)) }

        puzzle_card.setOnClickListener { startActivity(Intent(this , PuzzlesActivity :: class.java)) }

        actions_card.setOnClickListener { startActivity(Intent(this , ActionsActivity :: class.java)) }

        body_card.setOnClickListener { startActivity(Intent(this , BodyPartsActivity :: class.java)) }

        /**
        left_Slide_Button.setOnClickListener {

            this.move(MainActivity :: class.java)
        }
*/
    }
}