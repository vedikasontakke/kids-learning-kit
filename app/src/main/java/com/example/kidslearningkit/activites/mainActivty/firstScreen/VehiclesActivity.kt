package com.example.kidslearningkit.activites.mainActivty.firstScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_numbers.*
import kotlinx.android.synthetic.main.activity_vehicles.*

class VehiclesActivity : AppCompatActivity()  ,  View.OnClickListener {
    // var viewFlipper: ViewFlipper? = null
    // var next: Button? = null
    //  var previous: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        //  viewFlipper = findViewById<View>(R.id.viewFlipper) as ViewFlipper
        //   next = findViewById<View>(R.id.next) as Button
        //   previous = findViewById<View>(R.id.previous) as Button
        right_vehicle!!.setOnClickListener(this)
        left_vehicle!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_vehicle) {
            viewFlipper_vehicle!!.showNext()
        } else if (v === left_vehicle) {
            viewFlipper_vehicle!!.showPrevious()
        }
    }}
