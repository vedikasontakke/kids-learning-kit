package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_shapes.*
import java.lang.IllegalStateException

class ShapesActivity : AppCompatActivity()  , View.OnClickListener {

    lateinit var songsList: ArrayList<Int>
    var count = 0
    private  val TAG = "xShapesActivity"

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes)

        addSongs()

        right_shape!!.setOnClickListener(this)
        left_shape!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_shape.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_shapes.setOnClickListener{
            playSongByCount()
        }
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

            viewFlipper_shapes!!.showNext().also {

                playSongByCount()

            }
        } else if (v === left_shape) {

            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }

            viewFlipper_shapes!!.showPrevious().also {

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

            mediaPlayer = MediaPlayer.create(this, songsList[count])
            mediaPlayer.start()

        }catch(e:java.lang.Exception) {
            Log.e(TAG, "playSongByCount: Playing new song error ${e}", )
        }

        Log.e(TAG, "playSongByCount: Media Play song with $count", )
    }
}