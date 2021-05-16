package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_weeks.*

class WeeksActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weeks)

        addSongs()
        playSongByCount()

        play_week.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_week.setOnClickListener{
            playSongByCount()
        }

        right_week!!.setOnClickListener(this)
        left_week!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.sunday,
                R.raw.monday,
                R.raw.tuesday,
                R.raw.wednesday,
                R.raw.thrusday,
                R.raw.friday,
                R.raw.saturaday,
        )
    }

    override fun onClick(v: View) {
        if (v === right_week) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_week!!.showNext()
        } else if (v === left_week) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_week!!.showPrevious()
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
    }
}
