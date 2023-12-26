package com.example.shoppingmall_complexlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingmall_complexlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(R.layout.activity_main)
        }

    }
}