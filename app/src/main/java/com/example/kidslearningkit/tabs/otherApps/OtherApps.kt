package com.example.kidslearningkit.tabs.otherApps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kidslearningkit.R
import kotlinx.android.synthetic.main.activity_other__apps.*

class OtherApps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other__apps)

        try {
            webView.loadUrl("https://play.google.com/store/apps/dev?id=5879196017425043903")
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}