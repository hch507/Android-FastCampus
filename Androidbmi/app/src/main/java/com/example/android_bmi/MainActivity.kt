package com.example.android_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.resultButton.setOnClickListener {
            if (binding.height.text.isEmpty()||binding.weight.text.isEmpty()){
                Toast.makeText(this,"빈 값이 있습니다", Toast.LENGTH_SHORT).show()
                //리스러를 나가겟다
                return@setOnClickListener
            }
            val height : Int = binding.height.text.toString().toInt()
            val weight : Int = binding.weight.text.toString().toInt()

            val intent= Intent(this,ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}