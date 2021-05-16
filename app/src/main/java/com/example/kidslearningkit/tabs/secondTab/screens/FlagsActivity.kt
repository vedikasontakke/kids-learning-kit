package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_flags.*

class FlagsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)

        addSongs()
        playSongByCount()

        play_flag.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_flags.setOnClickListener{
            playSongByCount()
        }

        right_flag!!.setOnClickListener(this)
        left_flag!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.unitedkingdom,
                R.raw.usa,
                R.raw.indonesia,
                R.raw.france,
                R.raw.germany,
                R.raw.thailand,
                R.raw.philiooines,
                R.raw.australia,
                R.raw.india,
                R.raw.italy,
                )
    }

    override fun onClick(v: View) {
        if (v === right_flag) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_flags!!.showNext()
        } else if (v === left_flag) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_flags!!.showPrevious()
        }
    }

    private fun playSongByCount() {
        try {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
        } catch (e: UninitializedPropertyAccessException) { }
        mediaPlayer = MediaPlayer.create(this, songsList[count])
        mediaPlayer.start()
    }}
