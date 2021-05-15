package com.example.kidslearningkit.activites.mainActivty.firstScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_fruits.*

class FruitsActivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        right_fruit!!.setOnClickListener(this)
        left_fruit!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_fruit) {
            viewFlipper_fruits!!.showNext()
        } else if (v === left_fruit) {
            viewFlipper_fruits!!.showPrevious()
        }
    }}