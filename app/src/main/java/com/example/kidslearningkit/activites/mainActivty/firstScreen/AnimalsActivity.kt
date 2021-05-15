package com.example.kidslearningkit.activites.mainActivty.firstScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_animals.*
import kotlinx.android.synthetic.main.activity_numbers.*

class AnimalsActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        right_animal!!.setOnClickListener(this)
        left_animal!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === right_animal) {
            viewFlipper_animals!!.showNext()
        } else if (v === left_animal) {
            viewFlipper_animals!!.showPrevious()
        }
    }}
