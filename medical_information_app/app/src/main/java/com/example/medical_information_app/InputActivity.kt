package com.example.medical_information_app

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.medical_information_app.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInputBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter= ArrayAdapter.createFromResource(
            this,
            R.array.blood_type,
            android.R.layout.simple_list_item_1
        )

        binding.layer.setOnClickListener{
            var listener=OnDateSetListener{_, year, month, dayOfMonth->
                binding.birthEditTextView.text = "$year- ${month.inc()}- $dayOfMonth"

            }
            DatePickerDialog(
                this,
                listener,
                2000,
                1,
                1
            ).show()
        }

        binding.checkBox.setOnCheckedChangeListener { compoundButton, isChecked ->
            binding.cautionEditTextView.isVisible = isChecked
        }
        binding.cautionEditTextView.isVisible = binding.checkBox.isChecked
        binding.saveButton.setOnClickListener{
            saveData()
            finish()
        }
    }
    private fun saveData(){
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()){
            putString(NAME, binding.nameEditTextView.text.toString())
            putString(BLOOD_TYPE, getBloodType())
            putString(CONTACT, binding.emergencyEditTextView.text.toString())
            putString(BIRTHDATE, binding.birthEditTextView.text.toString())
            putString(WARNING, getWaring())
            apply()
        }


        Toast.makeText(this,"저장을 완료", Toast.LENGTH_SHORT).show()
    }
    private fun getBloodType():String{
        var bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if(binding.bloodTypePlus.isChecked)"+" else "-"
        return "$bloodSign$bloodAlphabet"
    }

    private fun getWaring(): String{
        return if (binding.checkBox.isChecked) binding.cautionEditTextView.text.toString() else ""
    }
}