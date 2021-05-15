package com.example.kidslearningkit.activites.mainActivty.firstScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_fruits.*
import kotlinx.android.synthetic.main.activity_shapes.*

class ShapesActivity : AppCompatActivity()  , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes)

        right_shape!!.setOnClickListener(this)
        left_shape!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_shape) {
            viewFlipper_shapes!!.showNext()
        } else if (v === left_shape) {
            viewFlipper_shapes!!.showPrevious()
        }
    }}