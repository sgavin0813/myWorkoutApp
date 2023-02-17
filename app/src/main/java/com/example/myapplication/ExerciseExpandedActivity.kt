package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ExerciseExpandedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_expaned)
        val imageExercise: ImageView = findViewById(R.id.image)
        val nameExercise: TextView = findViewById(R.id.name)
        val groupExercise: TextView = findViewById(R.id.group)
        val descExercise: TextView = findViewById(R.id.desc)
        val bundle = intent.extras
        val nameFromIntent = bundle!!.getString("name")
        val groupFromIntent = bundle!!.getString("group")
        val imageFromIntent = bundle!!.getInt("image")
        imageExercise.setImageResource(imageFromIntent)
        nameExercise.text = nameFromIntent
        groupExercise.text = groupFromIntent

    }
}