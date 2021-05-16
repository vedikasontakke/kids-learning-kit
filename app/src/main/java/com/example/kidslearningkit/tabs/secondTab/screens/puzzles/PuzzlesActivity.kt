package com.example.kidslearningkit.tabs.secondTab.screens.puzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidslearningkit.R
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.catPuzzle.CatPuzzleActivity
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.dogPuzzle.DogPuzzleActivity
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.lionPuzzle.LionPuzzleActivity
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.monkeyPuzzle.MonkeyPuzzleActivity
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.piesonPuzzle.PigeonPuzzleActivity
import com.example.kidslearningkit.tabs.secondTab.screens.puzzles.tigerPuzzle.TigerPuzzleActivity
import com.example.kidslearningkit.utils.move
import kotlinx.android.synthetic.main.activity_puzzles.*

class PuzzlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzles)

        pigeon_card.setOnClickListener{ this.move(PigeonPuzzleActivity::class.java) }
        lion_card.setOnClickListener{ this.move(LionPuzzleActivity::class.java) }
        cat_card.setOnClickListener{ this.move(CatPuzzleActivity::class.java) }
        dog_card.setOnClickListener{ this.move(DogPuzzleActivity::class.java) }
        monkey_card.setOnClickListener{ this.move(MonkeyPuzzleActivity::class.java) }
        tiger_card.setOnClickListener{ this.move(TigerPuzzleActivity::class.java) }


    }
}