package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_body_parts.*

class BodyPartsActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_parts)

        right_body!!.setOnClickListener(this)
        left_body!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_body) {
            viewFlipper_body!!.showNext()
        } else if (v === left_body) {
            viewFlipper_body!!.showPrevious()
        }
    }}
