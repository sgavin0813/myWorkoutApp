package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseListAdapter(private var dataList: List<ExerciseData>):
    RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder>() {
    lateinit var varListener : OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        varListener = listener
    }


    class ExerciseViewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        var exerciseName: TextView = itemView.findViewById<TextView>(R.id.exercise_name)
        var exerciseGroup: TextView = itemView.findViewById<TextView>(R.id.exercise_muscle)
        var exerciseImage: ImageView = itemView.findViewById<ImageView>(R.id.exercise_image)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ExerciseViewHolder {

        val itemView  =  LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return ExerciseViewHolder(itemView, varListener)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val individualExercise = dataList[position]
        holder.exerciseName.text = individualExercise.exerciseName
        holder.exerciseGroup.text = individualExercise.exerciseMuscle
        holder.exerciseImage.setImageResource(individualExercise.exerciseImage)
    }


}
