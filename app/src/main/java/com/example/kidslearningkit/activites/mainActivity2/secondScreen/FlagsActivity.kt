package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_flags.*

class FlagsActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)

        right_flag!!.setOnClickListener(this)
        left_flag!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_flag) {
            viewFlipper_flags!!.showNext()
        } else if (v === left_flag) {
            viewFlipper_flags!!.showPrevious()
        }
    }}
