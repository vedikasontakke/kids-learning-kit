package com.example.kidslearningkit.activites.mainActivity2.secondScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.kidslearningkit.activites.mainActivty.MainActivity
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN   // HERE TOOL BAR AND STATUS BAR IS GONE

        ic_logo.startAnimation(AnimationUtils.loadAnimation(this , R.anim.splash_in))

        Handler().postDelayed(
            {
                ic_logo.startAnimation(AnimationUtils.loadAnimation(this , R.anim.splash_out))

                Handler().postDelayed(
                    {
                        ic_logo.visibility = View.GONE

                        startActivity(Intent(this , MainActivity :: class.java))

                        finish()

                    }, 500)

            }, 1500)
    }
}