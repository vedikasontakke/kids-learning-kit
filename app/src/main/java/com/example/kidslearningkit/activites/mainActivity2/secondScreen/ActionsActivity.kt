package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_actions.*
import kotlinx.android.synthetic.main.activity_animals.*

class ActionsActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actions)

        right_actions!!.setOnClickListener(this)
        left_actions!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_actions) {
            viewFlipper_actions!!.showNext()
        } else if (v === left_actions) {
            viewFlipper_actions!!.showPrevious()
        }
    }}
