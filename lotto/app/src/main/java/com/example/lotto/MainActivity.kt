package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.lotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var didRun = false
    private val pickNumberSet = hashSetOf<Int>()
    private val numberText : List<TextView> by lazy {
        listOf<TextView>(
            binding.number1,
            binding.number2,
            binding.number3,
            binding.number4,
            binding.number5,
            binding.number6)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.numberPicker.apply {
            minValue=1
            maxValue=45
        }
        initRunButton()
        initAddButton()
        initClearButton()
    }

    private fun initRunButton(){
        binding.runButton.setOnClickListener {
            val list = getRandomNumber()


            didRun =true

            list.forEachIndexed{index, i ->
                val textView = numberText[index]

                textView.isVisible= true
                textView.text= i.toString()
            }
        }
    }
    private fun initAddButton(){
        binding.addButton.setOnClickListener {
            if (didRun){
                Toast.makeText(this, "초기화 후에 시도해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pickNumberSet.size>=5){
                Toast.makeText(this, "번호는 5개까지만 지정합니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pickNumberSet.contains(binding.numberPicker.value)){
                Toast.makeText(this, "이미 선택한 번호입니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val textView =numberText[pickNumberSet.size]
            textView.isVisible = true
            textView.text = binding.numberPicker.value.toString()

            pickNumberSet.add(binding.numberPicker.value)
        }
    }
    private fun initClearButton(){

        binding.clearButton.setOnClickListener {
            didRun=false
            pickNumberSet.clear()
            numberText.forEach{
                it.isVisible=false
            }
        }

    }

    private fun getRandomNumber():List<Int>{
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45){
                    if (pickNumberSet.contains(i)){
                        continue
                    }
                    this.add(i)
                }
            }

        numberList.shuffle()
        val newList= pickNumberSet.toList()+numberList.subList(0,6-pickNumberSet.size)

        return newList.sorted()
    }
}