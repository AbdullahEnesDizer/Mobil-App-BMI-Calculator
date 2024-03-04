package com.bmicalculator.eneshw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.bmicalculator.eneshw1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCalculate.setOnClickListener{

            val weight = binding.editTextWeight.text.toString().toDouble()
            val height = binding.editTextHeight.text.toString().toDouble() /100

            val bmi = calculateBMI(weight, height)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }

    }
    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}