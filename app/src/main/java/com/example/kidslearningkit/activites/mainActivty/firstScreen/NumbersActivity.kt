package com.example.kidslearningkit.activites.mainActivty.firstScreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_numbers.*

class NumbersActivity : AppCompatActivity() ,  View.OnClickListener {

    var songs: IntArray = intArrayOf(
            R.raw.one , R.raw.two , R.raw.three , R.raw.four , R.raw.five , R.raw.six , R.raw.seven , R.raw.eight , R.raw.nine , R.raw.ten)

  /*  var songs_number = Array<MediaPlayer>(
            R.raw.one , R.raw.two , R.raw.three , R.raw.four , R.raw.five , R.raw.six , R.raw.seven , R.raw.eight , R.raw.nine , R.raw.ten)*/

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        right_number!!.setOnClickListener(this)
        left_number!!.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v === right_number) {
            viewFlipper_numbers!!.showNext()

            count++
            var number : MediaPlayer = MediaPlayer.create(this , R.raw.eight)
            number.start()


        } else if (v === left_number) {
            viewFlipper_numbers!!.showPrevious()
        }
    }

}
