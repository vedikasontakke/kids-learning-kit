package com.example.kidslearningkit.tabs.firstTab.screens.alphabates

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_albhabates_2.*
import kotlinx.android.synthetic.main.activity_alphabate.*

class AlphabateActivity : AppCompatActivity() {

  //  var music: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabate)

        val intent = Intent(this , Albhabates_Activity2 :: class.java)

        right_albhabate.setOnClickListener { startActivity(intent) }


        var music_A : MediaPlayer? = MediaPlayer.create(this, R.raw.a)
        var music_B : MediaPlayer? = MediaPlayer.create(this, R.raw.b)
        var music_C : MediaPlayer? = MediaPlayer.create(this, R.raw.c)
        var music_D : MediaPlayer? = MediaPlayer.create(this, R.raw.d)
        var music_E : MediaPlayer? = MediaPlayer.create(this, R.raw.e)
        var music_F : MediaPlayer? = MediaPlayer.create(this, R.raw.f)
        var music_G : MediaPlayer? = MediaPlayer.create(this, R.raw.g)
        var music_H : MediaPlayer? = MediaPlayer.create(this, R.raw.h)
        var music_I : MediaPlayer? = MediaPlayer.create(this, R.raw.i)
        var music_J : MediaPlayer? = MediaPlayer.create(this, R.raw.j)
        var music_K : MediaPlayer? = MediaPlayer.create(this, R.raw.k)
        var music_L : MediaPlayer? = MediaPlayer.create(this, R.raw.l)
        var music_M : MediaPlayer? = MediaPlayer.create(this, R.raw.m)


        alphabate_A.setOnClickListener { music_A?.start() }
        alphabate_B.setOnClickListener { music_B?.start() }
        alphabate_C.setOnClickListener { music_C?.start() }
        alphabate_D.setOnClickListener { music_D?.start() }
        alphabate_E.setOnClickListener { music_E?.start() }
        alphabate_F.setOnClickListener { music_F?.start() }
        alphabate_G.setOnClickListener { music_G?.start() }
        alphabate_H.setOnClickListener { music_H?.start() }
        alphabate_I.setOnClickListener { music_I?.start() }
        alphabate_J.setOnClickListener { music_J?.start() }
        alphabate_K.setOnClickListener { music_K?.start() }
        alphabate_L.setOnClickListener { music_L?.start() }
        alphabate_M.setOnClickListener { music_M?.start() }


    }


}