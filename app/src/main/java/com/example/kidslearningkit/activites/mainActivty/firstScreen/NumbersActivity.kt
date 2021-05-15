package com.example.kidslearningkit.activites.mainActivty.firstScreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_numbers.*

class NumbersActivity : AppCompatActivity() ,  View.OnClickListener {

    lateinit var songsList: ArrayList<Int>
    var count = 0

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        addSongs()

        playSongByCount()

        play_number.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_numbers.setOnClickListener{
            playSongByCount()
        }

        right_number!!.setOnClickListener(this)
        left_number!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.one,
                R.raw.two,
                R.raw.three,
                R.raw.four,
                R.raw.five,
                R.raw.six,
                R.raw.seven,
                R.raw.eight,
                R.raw.nine,
                R.raw.ten
        )
    }


    override fun onClick(v: View) {
        if (v === right_number) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()


            viewFlipper_numbers!!.showNext()
        } else if (v === left_number) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_numbers!!.showPrevious()
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
