package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*

class AnimalsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var animalsSongs: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        addSongs()
        playSongByCount()

        play_animal.setOnClickListener {
           playSongByCount()
        }
        viewFlipper_animals.setOnClickListener{
            playSongByCount()
        }


        right_animal!!.setOnClickListener(this)
        left_animal!!.setOnClickListener(this)
    }


    private fun addSongs() {
        animalsSongs = arrayListOf(
                R.raw.lion,
                R.raw.cat,
                R.raw.dog,
                R.raw.bird,
                R.raw.chicken,
                R.raw.horse,
                R.raw.frog,
                R.raw.monkey,
                R.raw.elephant
        )
    }

    override fun onClick(v: View) {
        if (v === right_animal) {
            if (count == (animalsSongs.size-1)) {
                count = 0
            } else {
                count++
            }

            playSongByCount()
            viewFlipper_animals!!.showNext()

        } else if (v === left_animal) {
            if (count == 0) {
                count = (animalsSongs.size-1)
            } else {
                count--
            }
            playSongByCount()
            viewFlipper_animals!!.showPrevious()
        }
    }

    private fun playSongByCount() {
        try {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
        } catch (e: UninitializedPropertyAccessException) {
        }
        mediaPlayer = MediaPlayer.create(this, animalsSongs[count])
        mediaPlayer.start()
    }
}
