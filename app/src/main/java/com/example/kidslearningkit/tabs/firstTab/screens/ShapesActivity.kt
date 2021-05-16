package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_shapes.*

class ShapesActivity : AppCompatActivity()  , View.OnClickListener {

    lateinit var songsList: ArrayList<Int>
    var count = 0

    lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes)

        addSongs()

        playSongByCount()

        play_shape.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_shapes.setOnClickListener{
            playSongByCount()
        }


        right_shape!!.setOnClickListener(this)
        left_shape!!.setOnClickListener(this)
    }



    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.rectangle,
                R.raw.circle,
                R.raw.square,
                R.raw.triangle,
                R.raw.oval,
                R.raw.hexagon,
                R.raw.star,
                R.raw.octagon,
                R.raw.heart,
                R.raw.pentagon
        )
    }

    override fun onClick(v: View) {
        if (v === right_shape) {
            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_shapes!!.showNext()
        } else if (v === left_shape) {


            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()

            viewFlipper_shapes!!.showPrevious()
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