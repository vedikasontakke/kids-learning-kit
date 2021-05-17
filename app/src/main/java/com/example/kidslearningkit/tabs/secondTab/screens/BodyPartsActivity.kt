package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_body_parts.*
import java.lang.IllegalStateException

class BodyPartsActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer
    private val TAG = "xBodyPartsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_parts)

        addSongs()

        right_body!!.setOnClickListener(this)
        left_body!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_body.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_body.setOnClickListener{
            playSongByCount()
        }

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

            viewFlipper_body!!.showNext().also {

                playSongByCount()
            }
        } else if (v === left_body) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }

            viewFlipper_body!!.showPrevious().also {

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
