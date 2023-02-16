package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class BmiFragment : Fragment() {
    lateinit var viewToReturn : View
    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewToReturn = inflater.inflate(R.layout.fragment_bmi, container, false)
        val bmiButton = viewToReturn.findViewById<Button>(R.id.btnCalcBMI)
        val editWeight:EditText = viewToReturn.findViewById(R.id.weight)
        val editHeightF:EditText = viewToReturn.findViewById(R.id.heightFeet)
        val editHeightI: EditText = viewToReturn.findViewById(R.id.heightInch)
        val result:TextView = viewToReturn.findViewById(R.id.resultText)
        val errorText:TextView = viewToReturn.findViewById(R.id.errorText)
        val resetBMI: Button =  viewToReturn.findViewById<Button>(R.id.resetBMI)
        val fragmentLayoutBMI:View = viewToReturn.findViewById<View>(R.id.fragmentLayoutBMI)
        var weight:Float = 1.0F
        var heightInches:Float = 1.0F
        var heightFeet:Float = 1.0F
        var defaultFlag:Boolean = FALSE

        bmiButton.setOnClickListener{
            if (editWeight.text.toString().isEmpty() || editWeight.text.toString().toFloat()< 5.0F || editWeight.text.toString().toFloat() > 600.0F){
                defaultFlag = TRUE
            }
            else{
                weight = (editWeight.text.toString()).toFloat()
            }

            if ((editHeightF.text.toString()).isEmpty() || (editHeightF.text.toString()).toFloat() > 10.0F || (editHeightF.text.toString()).toFloat() <0.0F  ){
                defaultFlag = TRUE
            }
            else{
                heightFeet = (editHeightF.text.toString()).toFloat()
            }

            if ((editHeightI.text.toString()).isEmpty() || (editHeightI.text.toString()).toFloat()< 0.0F ){
                defaultFlag = TRUE
            }
            else if((editHeightI.text.toString()).toFloat() == 12.0F){
                heightInches = 0.0F
                heightFeet++;
            }
            else{
                heightInches = (editHeightI.text.toString()).toFloat()
            }




            val heightInchesTotal = heightInches + heightFeet * 12


            val bmi:Float = 703* (weight / (heightInchesTotal * heightInchesTotal))

            when {

                bmi < 16 -> {
                    result.text = "Severely Underweight"
                }
                bmi < 18.5 -> {
                    result.text = "Underweight"
                }
                bmi < 25 -> {
                    result.text = "Normal weight"
                }
                bmi < 30 -> {
                    result.text = " Overweight"
                }
                bmi <34.9 -> {
                    result.text = "Class I obese"
                }
                bmi <39.9-> {
                    result.text = "Class II obese"
                }
                else -> {
                    result.text = "Class III obese"
                }
            }
            if (defaultFlag == TRUE){
                errorText.visibility = View.VISIBLE
                result.text = "Hit Reset"
                errorText.text = "And! Enter a valid Weight and height!"
                //fragmentLayoutBMI.background = ColorDrawable(R.color.redWarning)
            }

        }

        resetBMI.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                editWeight.text.clear()
                editHeightI.text.clear()
                editHeightF.text.clear()
                errorText.visibility = View.INVISIBLE
                errorText.text = ""
                result.text = "Results"
            }

        })
        return viewToReturn
    }

}