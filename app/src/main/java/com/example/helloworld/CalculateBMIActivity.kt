package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.LineHeightSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculateBMIActivity : AppCompatActivity() {
    lateinit var btnCalculate:Button
    lateinit var etWeight:EditText
    lateinit var etHeight:EditText
    lateinit var tvBMI:TextView
    lateinit var tvStatus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmiactivity)

        btnCalculate = findViewById(R.id.btnCalculate)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvBMI=findViewById(R.id.tvBMI)
        tvStatus = findViewById(R.id.tvStatus)

        btnCalculate.setOnClickListener {
          var weight =etWeight.text.toString()
            var height =etHeight.text.toString()

         if (weight.isBlank()){
             etWeight.error ="Weight is required"
             return@setOnClickListener
         }
            if (height.isBlank()){
                etHeight.error ="Height is required"
                return@setOnClickListener
            }

            calculateBMI(weight.toDouble(),height.toInt())
        }
    }
    //Calculating BMI
    fun calculateBMI(weight:Double, height:Int){
        val heightMetres=height/100.0
        val bmi =weight/(heightMetres*heightMetres)
        tvBMI.text=bmi.toString()
        displayStatus(bmi)
    }
//display status
    fun displayStatus(bmi:Double){
        if (bmi<18.5) {
            tvStatus.text = "Healthy"
        }else if (bmi >=18.5 && bmi < 25.0){
            tvStatus.text ="Light"
        }else if (bmi >=25.0 && bmi < 30.0){
            tvStatus.text ="Overweight"
        }else if (bmi >=30.0){
            tvStatus.text ="Obesity"

        }
    }
}
