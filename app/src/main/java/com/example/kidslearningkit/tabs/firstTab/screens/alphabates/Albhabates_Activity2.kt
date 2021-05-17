package com.example.kidslearningkit.tabs.firstTab.screens.alphabates

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_albhabates_2.*
import kotlinx.android.synthetic.main.activity_alphabate.*

class Albhabates_Activity2 : AppCompatActivity() {

     var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albhabates_2)



        left_albhabate.setOnClickListener {   onBackPressed()  }

        val music_N : MediaPlayer? = MediaPlayer.create(this, R.raw.n)
        val music_O : MediaPlayer? = MediaPlayer.create(this, R.raw.o)
        val music_P : MediaPlayer? = MediaPlayer.create(this, R.raw.p)
        val music_Q : MediaPlayer? = MediaPlayer.create(this, R.raw.q)
        val music_R : MediaPlayer? = MediaPlayer.create(this, R.raw.r)
        val music_S : MediaPlayer? = MediaPlayer.create(this, R.raw.s)
        val music_T : MediaPlayer? = MediaPlayer.create(this, R.raw.t)
        val music_U : MediaPlayer? = MediaPlayer.create(this, R.raw.u)
        val music_V : MediaPlayer? = MediaPlayer.create(this, R.raw.v)
        val music_W : MediaPlayer? = MediaPlayer.create(this, R.raw.w)
        val music_X : MediaPlayer? = MediaPlayer.create(this, R.raw.x)
        val music_Y : MediaPlayer? = MediaPlayer.create(this, R.raw.y)
        val music_Z : MediaPlayer? = MediaPlayer.create(this, R.raw.z)

        alphabate_N.setOnClickListener { playSong(R.raw.n) }
        alphabate_O.setOnClickListener { playSong(R.raw.o) }
        alphabate_P.setOnClickListener { playSong(R.raw.p) }
        alphabate_Q.setOnClickListener { playSong(R.raw.q) }
        alphabate_R.setOnClickListener { playSong(R.raw.r) }
        alphabate_S.setOnClickListener { playSong(R.raw.s) }
        alphabate_T.setOnClickListener { playSong(R.raw.t) }
        alphabate_U.setOnClickListener { playSong(R.raw.u) }
        alphabate_V.setOnClickListener { playSong(R.raw.v) }
        alphabate_W.setOnClickListener { playSong(R.raw.w) }
        alphabate_X.setOnClickListener { playSong(R.raw.x) }
        alphabate_Y.setOnClickListener { playSong(R.raw.y) }
        alphabate_Z.setOnClickListener { playSong(R.raw.z) }

    }

    private fun playSong(rawfile: Int) {
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, rawfile)
            mediaPlayer?.start()
        }else if(mediaPlayer != null){
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.reset()
                mediaPlayer?.release()
            }
            mediaPlayer = MediaPlayer.create(this, rawfile)
            mediaPlayer?.start()

        }


    }

}