package com.example.kidslearningkit.tabs.firstTab

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.*
import com.example.kidslearningkit.tabs.secondTab.SecondTab
import com.example.kidslearningkit.tabs.firstTab.screens.*
import com.example.kidslearningkit.tabs.firstTab.screens.alphabates.AlphabateActivity
import com.example.kidslearningkit.tabs.otherApps.OtherApps
import com.example.kidslearningkit.utils.move
import kotlinx.android.synthetic.main.activity_main.*


class FirstTab : AppCompatActivity() {

    lateinit var  mediaPlayer:MediaPlayer

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