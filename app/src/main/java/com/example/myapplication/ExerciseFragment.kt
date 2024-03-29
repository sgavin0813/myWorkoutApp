package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExerciseFragment : Fragment()
{
    private lateinit var exerciseViewToReturn : View
    private lateinit var recyclerExercise : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        exerciseViewToReturn =  inflater.inflate(R.layout.fragment_exercise, container, false)

        val recyclerExercise = exerciseViewToReturn.findViewById<RecyclerView>(R.id.recyclerLayoutForExercise)
        recyclerExercise.layoutManager = LinearLayoutManager(this.context)
        val adapter = ExerciseListAdapter(exerciseList)
        recyclerExercise.adapter = adapter
        adapter.setOnItemClickListener(object : ExerciseListAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(),ExerciseExpandedActivity::class.java)
                intent.putExtra("name",exerciseList[position].exerciseName)
                intent.putExtra("group",exerciseList[position].exerciseMuscle)
                intent.putExtra("image",exerciseList[position].exerciseImage)
                startActivity(intent)
            }
        })

        return exerciseViewToReturn
    }
}