package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_flags.*
import java.lang.IllegalStateException

class FlagsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer
    private  val TAG = "xFlagsActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)

        addSongs()


        right_flag!!.setOnClickListener(this)
        left_flag!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_flag.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_flags.setOnClickListener{
            playSongByCount()
        }
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.unitedkingdom,
                R.raw.usa,
                R.raw.indonesia,
                R.raw.france,
                R.raw.germany,
                R.raw.thailand,
                R.raw.philiooines,
                R.raw.australia,
                R.raw.india,
                R.raw.italy,
                )
    }

    override fun onClick(v: View) {
        if (v === right_flag) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            viewFlipper_flags!!.showNext().also {

                playSongByCount()
            }
        }
        else if (v === left_flag)
        {
            if (count == 0) {
                count = (songsList.size-1)
            }
            else {
                count--
            }

            viewFlipper_flags!!.showPrevious().also {

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
