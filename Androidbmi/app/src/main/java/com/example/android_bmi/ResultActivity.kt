package com.example.android_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_bmi.databinding.ActivityMainBinding
import com.example.android_bmi.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val bmi = weight/(height/100.0).pow(2.0)
        val resultText = when{
            bmi>=35.0 -> "고도비민"
            bmi>=30.0 -> "중정도비민"
            bmi>=25.0 -> "경도비민"
            bmi>=23.0 -> "과체중"
            bmi>=18.5 -> "정상"
            else-> "저체중"
        }

        binding.resultBmi.text=bmi.toString()
        binding.result.text=resultText

    }
}