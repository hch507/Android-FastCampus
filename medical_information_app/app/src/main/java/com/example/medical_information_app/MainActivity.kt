package com.example.medical_information_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.medical_information_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goInputActivityButton.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            intent.putExtra("intentMessage","응급 의료정보")
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        getDataUiUpdate()
    }
    private fun getDataUiUpdate(){
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE)) {
            binding.nameValueTextView.text =getString(NAME,"미정")
            binding.birthValueTextView.text =getString(BIRTHDATE,"미정")
            binding.birthValueTextView.text =getString(BLOOD_TYPE,"미정")
            binding.emergencyValueTextView.text =getString(CONTACT,"미정")
            val warning =getString(WARNING,"")
            binding.cautionTextView.isVisible=warning.isNullOrEmpty().not()
            binding.cautionValueTextView.isVisible=warning.isNullOrEmpty().not()
            if (warning.isNullOrEmpty()){
              binding.cautionValueTextView.text=warning
            }

        }
    }

}