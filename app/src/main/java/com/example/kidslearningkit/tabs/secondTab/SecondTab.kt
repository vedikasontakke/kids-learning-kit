package com.example.kidslearningkit.tabs.secondTab

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.tabs.secondTab.screens.*
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.PuzzlesActivity
import com.example.kidslearningkit.tabs.firstTab.FirstTab
import com.example.kidslearningkit.tabs.otherApps.OtherApps
import com.example.kidslearningkit.utils.move
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.question

class SecondTab : AppCompatActivity() {

    lateinit var mediaPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        left_Slide_Button.setOnClickListener { onBackPressed() }

        months_card.setOnClickListener { startActivity(Intent(this , MonthsActivity :: class.java)) }

        weeks_card.setOnClickListener { startActivity(Intent(this , WeeksActivity :: class.java)) }

        flags_card.setOnClickListener { startActivity(Intent(this , FlagsActivity :: class.java)) }

        puzzle_card.setOnClickListener { startActivity(Intent(this , PuzzlesActivity :: class.java)) }

        actions_card.setOnClickListener { startActivity(Intent(this , ActionsActivity :: class.java)) }

        body_card.setOnClickListener { startActivity(Intent(this , BodyPartsActivity :: class.java)) }

        question.setOnClickListener {
            this.move(OtherApps::class.java)
        }

    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.bg_music).apply {
            start()
            isLooping = true
        }
    }

    override fun onPause() {
        super.onPause()
        if(mediaPlayer.isPlaying){
            mediaPlayer.stop()
        }
    }
}