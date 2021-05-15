package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_weeks.*

class WeeksActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weeks)

        right_week!!.setOnClickListener(this)
        left_week!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_week) {
            viewFlipper_week!!.showNext()
        } else if (v === left_week) {
            viewFlipper_week!!.showPrevious()
        }
    }}
