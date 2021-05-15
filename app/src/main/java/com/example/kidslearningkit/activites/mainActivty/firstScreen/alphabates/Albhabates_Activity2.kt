package com.example.kidslearningkit.activites.mainActivty.firstScreen.alphabates

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_albhabates_2.*
import kotlinx.android.synthetic.main.activity_alphabate.*

class Albhabates_Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albhabates_2)

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        left_albhabate.setOnClickListener { startActivity(Intent(this , AlphabateActivity :: class.java)) }

        val music_N : MediaPlayer? = MediaPlayer.create(this, R.raw.n)
        val music_O : MediaPlayer? = MediaPlayer.create(this, R.raw.o)
        val music_P : MediaPlayer? = MediaPlayer.create(this, R.raw.p)
        val music_Q : MediaPlayer? = MediaPlayer.create(this, R.raw.q)
        val music_R : MediaPlayer? = MediaPlayer.create(this, R.raw.r)
        val music_S : MediaPlayer? = MediaPlayer.create(this, R.raw.s)
        val music_T : MediaPlayer? = MediaPlayer.create(this, R.raw.t)
        val music_U : MediaPlayer? = MediaPlayer.create(this, R.raw.u)
        val music_V : MediaPlayer? = MediaPlayer.create(this, R.raw.v)
        val music_W : MediaPlayer? = MediaPlayer.create(this, R.raw.w)
        val music_X : MediaPlayer? = MediaPlayer.create(this, R.raw.x)
        val music_Y : MediaPlayer? = MediaPlayer.create(this, R.raw.y)
        val music_Z : MediaPlayer? = MediaPlayer.create(this, R.raw.z)

        alphabate_N.setOnClickListener { music_N?.start() }
        alphabate_O.setOnClickListener { music_O?.start() }
        alphabate_P.setOnClickListener { music_P?.start() }
        alphabate_Q.setOnClickListener { music_Q?.start() }
        alphabate_R.setOnClickListener { music_R?.start() }
        alphabate_S.setOnClickListener { music_S?.start() }
        alphabate_T.setOnClickListener { music_T?.start() }
        alphabate_U.setOnClickListener { music_U?.start() }
        alphabate_V.setOnClickListener { music_V?.start() }
        alphabate_W.setOnClickListener { music_W?.start() }
        alphabate_X.setOnClickListener { music_X?.start() }
        alphabate_Y.setOnClickListener { music_Y?.start() }
        alphabate_Z.setOnClickListener { music_Z?.start() }

    }

}