package com.example.kidslearningkit.tabs.secondTab.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_months.*
import java.lang.IllegalStateException

class MonthsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var songsList: ArrayList<Int>
    var count = 0
    lateinit var mediaPlayer: MediaPlayer
    private  val TAG = "xMonthsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_months)

        addSongs()


        right_month!!.setOnClickListener(this)
        left_month!!.setOnClickListener(this)
    }

    private fun addSongs() {
        songsList = arrayListOf(
                R.raw.january,
                R.raw.februvary,
                R.raw.march,
                R.raw.april,
                R.raw.may,
                R.raw.june,
                R.raw.jully,
                R.raw.august,
                R.raw.september,
                R.raw.october,
                R.raw.november,
                R.raw.december,

                )
    }

    override fun onStart() {
        super.onStart()

        playSongByCount()

        play_month.setOnClickListener {
            playSongByCount()
        }
        viewFlipper_months.setOnClickListener{
            playSongByCount()
        }
    }

    override fun onClick(v: View) {
        if (v === right_month) {

            if (count == (songsList.size-1)) {
                count = 0
            } else {
                count++
            }



            viewFlipper_months!!.showNext().also {

                playSongByCount()
            }
        } else if (v === left_month) {
            if (count == 0) {
                count = (songsList.size-1)
            } else {
                count--
            }
            viewFlipper_months!!.showPrevious().also {

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
