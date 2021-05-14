package com.example.kidslearningkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ViewFlipper
import kotlinx.android.synthetic.main.activity_numbers.*

class NumbersActivity : AppCompatActivity() ,  View.OnClickListener {
   // var viewFlipper: ViewFlipper? = null
   // var next: Button? = null
  //  var previous: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

      //  viewFlipper = findViewById<View>(R.id.viewFlipper) as ViewFlipper
     //   next = findViewById<View>(R.id.next) as Button
     //   previous = findViewById<View>(R.id.previous) as Button
        right_number!!.setOnClickListener(this)
        left_number!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_number) {
            viewFlipper!!.showNext()
        } else if (v === left_number) {
            viewFlipper!!.showPrevious()
        }
    }}
