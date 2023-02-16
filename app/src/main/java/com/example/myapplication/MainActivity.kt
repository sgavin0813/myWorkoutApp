package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
var exerciseList = mutableListOf<ExerciseData>()
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeList()
        val bmiButton = findViewById<Button>(R.id.bmiButton)
        bmiButton.setOnClickListener{
            replaceFragment(BmiFragment())
        }

        val exerciseListButton = findViewById<Button>(R.id.exerciseListButton)
        exerciseListButton.setOnClickListener {
            replaceFragment(ExerciseFragment())
        }
    }
    private fun initializeList(){
        for (i in 0..10){
        exerciseList.add(ExerciseData("name","Group",R.drawable.one))
    }
    }
    private fun replaceFragment( currentFragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentFrame,currentFragment)
        fragmentTransaction.commit()
    }


}