package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_body_parts.*
import kotlinx.android.synthetic.main.activity_weeks.*

class BodyPartsActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_parts)

        addSongs()
        playSongByCount()

        play_body.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_body.setOnClickListener{
            playSongByCount()
        }

        right_body!!.setOnClickListener(this)
        left_body!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.ear,
                R.raw.eye,
                R.raw.nose,
                R.raw.mouth,
                R.raw.chin,
                R.raw.hand,
                R.raw.elbow,
                R.raw.sholder,
                R.raw.ankel,
                R.raw.knee
        )
    }

    override fun onClick(v: View) {
        if (v === right_body) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()

            viewFlipper_body!!.showNext()
        } else if (v === left_body) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_body!!.showPrevious()
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
