package com.example.kidslearningkit.utils

import android.content.Context
import android.content.Intent

fun <T> Context.move(anyClass:Class<T>){
    Intent(this,anyClass).apply {
        this@move.startActivity(this)
    }
}