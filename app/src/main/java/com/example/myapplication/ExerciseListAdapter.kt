package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseListAdapter(private var dataList: List<ExerciseData>):
    RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder>() {


    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var exerciseName: TextView = itemView.findViewById<TextView>(R.id.exercise_name)
        var exerciseGroup: TextView = itemView.findViewById<TextView>(R.id.exercise_muscle)
        var exerciseImage: ImageView = itemView.findViewById<ImageView>(R.id.exercise_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=  ExerciseViewHolder(
         LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false) )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val individualExercise = dataList[position]
        holder.exerciseName.text = individualExercise.exerciseName
        holder.exerciseGroup.text = individualExercise.exerciseMuscle
        holder.exerciseImage.setImageResource(individualExercise.exerciseImage)
    }


}