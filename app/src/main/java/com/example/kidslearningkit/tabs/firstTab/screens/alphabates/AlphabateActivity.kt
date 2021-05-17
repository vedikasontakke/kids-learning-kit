package com.example.kidslearningkit.tabs.firstTab.screens.alphabates

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_albhabates_2.*
import kotlinx.android.synthetic.main.activity_alphabate.*

class AlphabateActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabate)

        val intent = Intent(this, Albhabates_Activity2::class.java)

        right_albhabate.setOnClickListener { startActivity(intent) }

        alphabate_A.setOnClickListener { playSong(R.raw.a) }
        alphabate_B.setOnClickListener { playSong(R.raw.b) }
        alphabate_C.setOnClickListener { playSong(R.raw.c) }
        alphabate_D.setOnClickListener { playSong(R.raw.d) }
        alphabate_E.setOnClickListener { playSong(R.raw.e) }
        alphabate_F.setOnClickListener { playSong(R.raw.f) }
        alphabate_G.setOnClickListener { playSong(R.raw.g) }
        alphabate_H.setOnClickListener { playSong(R.raw.h) }
        alphabate_I.setOnClickListener { playSong(R.raw.i) }
        alphabate_J.setOnClickListener { playSong(R.raw.j) }
        alphabate_K.setOnClickListener { playSong(R.raw.k) }
        alphabate_L.setOnClickListener { playSong(R.raw.l) }
        alphabate_M.setOnClickListener { playSong(R.raw.m) }


    }

    private fun playSong(rawfile: Int) {
        if(mediaPlayer != null){
            mediaPlayer?.pause()
            mediaPlayer?.release()
        }

        mediaPlayer = MediaPlayer.create(this, rawfile)
        mediaPlayer?.start()

    }


}