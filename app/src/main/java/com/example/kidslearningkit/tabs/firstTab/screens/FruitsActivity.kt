package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_fruits.*
import java.lang.IllegalStateException

class FruitsActivity : AppCompatActivity() , View.OnClickListener {

    private  val TAG = "xFruitsActivity"
    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        addSongs()

        right_fruit!!.setOnClickListener(this)
        left_fruit!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_fruit.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_fruits.setOnClickListener{
            playSongByCount()
        }

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

            viewFlipper_fruits!!.showNext().also {
                playSongByCount()
            }
        } else if (v === left_fruit) {

            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }

            viewFlipper_fruits!!.showPrevious().also {
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
                }catch (e:IllegalStateException){
                    Log.e(TAG, "playSongByCount: RESET -- 1", )
                }
                try {
                    mediaPlayer.release()
                } catch (e: UninitializedPropertyAccessException) {
                    Log.e(TAG, "playSongByCount: RELEASE", )
                }catch (e:IllegalStateException){
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

            mediaPlayer = MediaPlayer.create(this, songsList[count])
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