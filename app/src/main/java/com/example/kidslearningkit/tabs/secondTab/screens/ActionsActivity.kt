package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_actions.*

class ActionsActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actions)

        addSongs()
        playSongByCount()

        play_actions.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_actions.setOnClickListener{
            playSongByCount()
        }


        right_actions!!.setOnClickListener(this)
        left_actions!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.football,
                R.raw.basketball,
                R.raw.volleyball,
                R.raw.boxing,
                R.raw.tennis,
                R.raw.badmintoon,
                R.raw.golf,
                R.raw.criket,
                R.raw.fieldhockey,
                R.raw.karate,
        )
    }

    override fun onClick(v: View) {
        if (v === right_actions) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_actions!!.showNext()
        } else if (v === left_actions) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_actions!!.showPrevious()
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
