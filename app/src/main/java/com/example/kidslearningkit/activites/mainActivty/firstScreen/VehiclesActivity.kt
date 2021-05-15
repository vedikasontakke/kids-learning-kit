package com.example.kidslearningkit.activites.mainActivty.firstScreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_numbers.*
import kotlinx.android.synthetic.main.activity_shapes.*
import kotlinx.android.synthetic.main.activity_vehicles.*

class VehiclesActivity : AppCompatActivity()  ,  View.OnClickListener {
    lateinit var songsList: ArrayList<Int>
    var count = 0

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)
        addSongs()

        playSongByCount()

        play_vehicle.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_vehicle.setOnClickListener{
            playSongByCount()
        }


        right_vehicle!!.setOnClickListener(this)
        left_vehicle!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.airplane,
                R.raw.bus,
                R.raw.car,
                R.raw.helicopter,
                R.raw.motorcycle,
                R.raw.ship,
                R.raw.truck,
                R.raw.train,
                R.raw.yacht,
                R.raw.bicycle
        )
    }

    override fun onClick(v: View) {
        if (v === right_vehicle) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_vehicle!!.showNext()
        } else if (v === left_vehicle) {

            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()

            viewFlipper_vehicle!!.showPrevious()
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



