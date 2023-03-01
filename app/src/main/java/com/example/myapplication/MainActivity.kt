package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

var exerciseList = mutableListOf<ExerciseData>()
class MainActivity : AppCompatActivity() {
    lateinit var toggleHamB : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navBar: NavigationView = findViewById(R.id.navBar)
        val drawerMenu : DrawerLayout = findViewById(R.id.drawerMenu)
        initializeList()
        //this is what home fragment would be
        replaceFragment(BmiFragment())
        toggleHamB = ActionBarDrawerToggle(this,drawerMenu,R.string.open,R.string.close)
        drawerMenu.addDrawerListener(toggleHamB)
        toggleHamB.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true )
        navBar.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.homeButton -> {
                    replaceFragment(BmiFragment())
                }

                R.id.exerciseList -> {
                    replaceFragment(ExerciseFragment())
                }
            }

            true
        }



    }
    //onOptionsItemSelected-> handle user clicks on the options menu of the app
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //checks if toggleHamB is the menuItem we have selected
        if (toggleHamB.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
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

            exerciseList.add(ExerciseData("Lats Pull-down","Back",R.drawable.lats))



            exerciseList.add(ExerciseData("Curls","Biceps",R.drawable.curls))
            exerciseList.add(ExerciseData("Reverse Curls","Biceps",R.drawable.reversecurls))
            exerciseList.add(ExerciseData("Inclined Curls","Biceps",R.drawable.inclinedcurls))
            exerciseList.add(ExerciseData("Preachers Curls","Biceps",R.drawable.curls))

            exerciseList.add(ExerciseData("Squats","Legs",R.drawable.squat))
            exerciseList.add(ExerciseData("Curls","Lower Body",R.drawable.deadlift))


    }
    private fun replaceFragment( currentFragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentFrame,currentFragment)
        fragmentTransaction.commit()
    }


}