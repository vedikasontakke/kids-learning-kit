package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_months.*

class monthsActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_months)

        right_month!!.setOnClickListener(this)
        left_month!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_month) {
            viewFlipper_months!!.showNext()
        } else if (v === left_month) {
            viewFlipper_months!!.showPrevious()
        }
    }}
