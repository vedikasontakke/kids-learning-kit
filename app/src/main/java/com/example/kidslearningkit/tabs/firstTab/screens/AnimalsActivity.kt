package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_numbers.*
import java.lang.IllegalStateException

class AnimalsActivity : AppCompatActivity(), View.OnClickListener {

    private  val TAG = "xAnimalsActivity"

    lateinit var animalsSongs: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        addSongs()

        right_animal!!.setOnClickListener(this)
        left_animal!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_animal.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_animals.setOnClickListener{
            playSongByCount()
        }
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

            //  playSongByCount()

            viewFlipper_animals!!.showNext().also {

                playSongByCount()

            }
        } else if (v === left_animal) {
            if (count == 0) {
                count = (animalsSongs.size-1)
            } else {
                count--
            }
            viewFlipper_animals!!.showPrevious().also {

                playSongByCount()

            }
        }
    }


    private fun playSongByCount() {
        try {
            if (mediaPlayer.isPlaying) {
                try{
                    mediaPlayer.reset()
                }catch (e:UninitializedPropertyAccessException){
                    Log.e(TAG, "playSongByCount: RESET -- 1", )
                }catch (e: IllegalStateException){
                    Log.e(TAG, "playSongByCount: RESET -- 1", )
                }

                try {
                    mediaPlayer.release()
                } catch (e: UninitializedPropertyAccessException) {
                    Log.e(TAG, "playSongByCount: RELEASE", )
                }catch (e: IllegalStateException){
                    Log.e(TAG, "playSongByCount: RELEASE", )
                }
            }
        } catch (e: UninitializedPropertyAccessException) {
            Log.e(TAG, "playSongByCount: Is Activity Started Then media Player is Not Initialize", )
        }
        try {
            mediaPlayer.release()
        }catch (e:java.lang.Exception){
            Log.e(TAG, "playSongByCount: RELEASE - 2", )
        }
        try {

            mediaPlayer = MediaPlayer.create(this, animalsSongs[count])
            mediaPlayer.start()

        }catch(e:java.lang.Exception) {
            Log.e(TAG, "playSongByCount: Playing new song error ${e}", )
        }

        Log.e(TAG, "playSongByCount: Media Play song with $count", )
    }

    override fun onStop() {
        super.onStop()
        try {
            mediaPlayer.release()
            mediaPlayer.stop()
        } catch (e: Exception) {

        }
    }
}
