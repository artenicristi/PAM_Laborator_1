package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val weightInput = findViewById<TextView>(R.id.weightInput)
        val heightInput = findViewById<TextView>(R.id.heightInput)
        val bmiResult = findViewById<TextView>(R.id.bmiResult)
        val bmiType = findViewById<TextView>(R.id.bmiType)
        val bmiImage = findViewById<ImageView>(R.id.bmiImage)

        calculateBtn.setOnClickListener{
            val weight = weightInput.text.toString().toDouble()
            val height = heightInput.text.toString().toDouble() / 100
            val result = weight / height.pow(2)

            bmiResult.text = (Math.round(result * 100.0) / 100.0).toString()

            if (result < 18.5) {
                bmiType.text = "Underweight"
                bmiType.setTextColor(Color.parseColor("#00BCD4"))
                bmiImage.setImageResource(R.drawable.under_weight)
            } else if (result < 25) {
                bmiType.text = "Normal"
                bmiType.setTextColor(Color.parseColor("#4CAF50"))
                bmiImage.setImageResource(R.drawable.normal)
            } else if (result < 30) {
                bmiType.text = "Overweight"
                bmiType.setTextColor(Color.parseColor("#FFEB3B"))
                bmiImage.setImageResource(R.drawable.overweight)
            } else if (result < 35) {
                bmiType.text = "Obese"
                bmiType.setTextColor(Color.parseColor("#FF9800"))
                bmiImage.setImageResource(R.drawable.obese)
            } else {
                bmiType.text = "Extremely obese"
                bmiType.setTextColor(Color.parseColor("#F44336"))
                bmiImage.setImageResource(R.drawable.extremely_obese)
            }
        }
    }
}