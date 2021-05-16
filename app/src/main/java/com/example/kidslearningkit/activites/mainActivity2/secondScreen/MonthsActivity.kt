package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_months.*
import kotlinx.android.synthetic.main.activity_weeks.*

class monthsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_months)

        addSongs()
        playSongByCount()

        play_month.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_months.setOnClickListener{
            playSongByCount()
        }

        right_month!!.setOnClickListener(this)
        left_month!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.january,
                R.raw.februvary,
                R.raw.march,
                R.raw.april,
                R.raw.may,
                R.raw.june,
                R.raw.jully,
                R.raw.august,
                R.raw.september,
                R.raw.october,
                R.raw.november,
                R.raw.december,

                )
    }

    override fun onClick(v: View) {
        if (v === right_month) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_months!!.showNext()
        } else if (v === left_month) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_months!!.showPrevious()
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
