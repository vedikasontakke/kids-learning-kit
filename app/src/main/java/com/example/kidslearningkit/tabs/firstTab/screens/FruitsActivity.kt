package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_fruits.*

class FruitsActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var songsList: ArrayList<Int>
    var count = 0

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        addSongs()

        playSongByCount()

        play_fruit.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_fruits.setOnClickListener{
            playSongByCount()
        }



        right_fruit!!.setOnClickListener(this)
        left_fruit!!.setOnClickListener(this)
    }


    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.apple,
                R.raw.orange,
                R.raw.watermelon,
                R.raw.mango,
                R.raw.grapes,
                R.raw.banana,
                R.raw.strawberry,
                R.raw.tomato,
                R.raw.kiwi,
                R.raw.carrot
        )
    }

    override fun onClick(v: View) {
        if (v === right_fruit) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()


            viewFlipper_fruits!!.showNext()
        } else if (v === left_fruit) {

            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()

            viewFlipper_fruits!!.showPrevious()
        }
    }

    private fun playSongByCount() {
        try {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
        } catch (e: UninitializedPropertyAccessException) {
        }
        mediaPlayer = MediaPlayer.create(this, songsList[count])
        mediaPlayer.start()
    }
}