package com.example.kidslearningkit.tabs.firstTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_numbers.*
import java.lang.IllegalStateException

class NumbersActivity : AppCompatActivity() ,  View.OnClickListener {

    private  val TAG = "xNumbersActivity"

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        addSongs()

        right_number!!.setOnClickListener(this)
        left_number!!.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_number.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_numbers.setOnClickListener{
            playSongByCount()
        }

    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.one,
                R.raw.two,
                R.raw.three,
                R.raw.four,
                R.raw.five,
                R.raw.six,
                R.raw.seven,
                R.raw.eight,
                R.raw.nine,
                R.raw.ten
        )
    }

    override fun onClick(v: View) {
        if (v === right_number) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }

          //  playSongByCount()

            viewFlipper_numbers!!.showNext().also {

                playSongByCount()

            }
        } else if (v === left_number) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            viewFlipper_numbers!!.showPrevious().also {

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

    override fun onStop() {
        super.onStop()
        try {
            mediaPlayer.release()
            mediaPlayer.stop()
        } catch (e: Exception) {

        }
    }}
