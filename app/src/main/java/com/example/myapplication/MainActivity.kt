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

            exerciseList.add(ExerciseData("Bench press","Chest",R.drawable.benchpress))
            exerciseList.add(ExerciseData("Inclined press","Chest",R.drawable.inclined))
            exerciseList.add(ExerciseData("Dumbbell press","Chest",R.drawable.benchpress))
            exerciseList.add(ExerciseData("Cable Flies","Chest",R.drawable.inclined))

            exerciseList.add(ExerciseData("Shoulder press","Shoulder",R.drawable.sholderpress))
            exerciseList.add(ExerciseData("Side Raises","Shoulder",R.drawable.sideraise))
            exerciseList.add(ExerciseData("Lateral Raises","Shoulder",R.drawable.sholderpress))
            exerciseList.add(ExerciseData("Shoulder press","Shoulder",R.drawable.sideraise))

            exerciseList.add(ExerciseData("Lats Pulldown","Back",R.drawable.lats))
            exerciseList.add(ExerciseData("Curls","Biceps",R.drawable.curls))
            exerciseList.add(ExerciseData("Curls","Biceps",R.drawable.curls))
            exerciseList.add(ExerciseData("Curls","Biceps",R.drawable.curls))
            exerciseList.add(ExerciseData("Curls","Biceps",R.drawable.curls))

    }
    private fun replaceFragment( currentFragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentFrame,currentFragment)
        fragmentTransaction.commit()
    }


}