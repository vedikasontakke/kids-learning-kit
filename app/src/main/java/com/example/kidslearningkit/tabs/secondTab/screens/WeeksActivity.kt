package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_weeks.*
import java.lang.IllegalStateException

class WeeksActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer
    private  val TAG = "xWeeksActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weeks)

        addSongs()


        right_week!!.setOnClickListener(this)
        left_week!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.sunday,
                R.raw.monday,
                R.raw.tuesday,
                R.raw.wednesday,
                R.raw.thrusday,
                R.raw.friday,
                R.raw.saturaday,
        )
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_week.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_week.setOnClickListener{
            playSongByCount()
        }
    }

    override fun onClick(v: View) {
        if (v === right_week) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }


            viewFlipper_week!!.showNext().also {
                playSongByCount()


            }
        } else if (v === left_week) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            viewFlipper_week!!.showPrevious().also {

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
