package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_actions.*
import java.lang.IllegalStateException

class ActionsActivity : AppCompatActivity(), View.OnClickListener{
    private  val TAG = "ActionsActivity"
    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actions)

        addSongs()

        right_actions!!.setOnClickListener(this)
        left_actions!!.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_actions.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_actions.setOnClickListener{
            playSongByCount()
        }


    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.football,
                R.raw.basketball,
                R.raw.volleyball,
                R.raw.boxing,
                R.raw.tennis,
                R.raw.badmintoon,
                R.raw.golf,
                R.raw.criket,
                R.raw.fieldhockey,
                R.raw.karate,
        )
    }

    override fun onClick(v: View) {
        if (v === right_actions) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

            viewFlipper_actions!!.showNext().also {
                playSongByCount()
            }
        } else if (v === left_actions) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }

            viewFlipper_actions!!.showPrevious().also {
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
