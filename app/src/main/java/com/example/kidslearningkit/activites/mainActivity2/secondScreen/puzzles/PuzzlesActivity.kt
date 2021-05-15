package com.example.kidslearningkit.activites.mainActivity2.secondScreen.puzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import com.example.kidslearningkit.activites.mainActivity2.secondScreen.puzzles.piesonPuzzle.PigeonPuzzleActivity
import com.example.kidslearningkit.utils.move
import kotlinx.android.synthetic.main.activity_puzzles.*

class PuzzlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzles)

        pigeon_card.setOnClickListener{ this.move(PigeonPuzzleActivity::class.java) }
    }
}