package com.example.pushalarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pushalarm.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFirebase()
    }
    private fun initFirebase(){
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    binding.firebaseTokenTextView.text=task.result
                }

            }
    }
}