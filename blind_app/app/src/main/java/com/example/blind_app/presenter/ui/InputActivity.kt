package com.example.blind_app.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.blind_app.databinding.ActivityInputBinding
import com.example.blind_app.domain.model.Content
import com.example.blind_app.presenter.viewmodel.InputViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private val viewModel : InputViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(binding.root)
            lifecycleOwner=this@InputActivity
            viewModel =this@InputActivity.viewModel
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        (intent.getSerializableExtra(ITEM)as? Content)?.let {
            viewModel.initData(it)
        }
        observeViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    private fun observeViewModel(){
        viewModel.doneEvent.observe(this){
            Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            if (it.first){
                finish()
            }
        }
    }
    companion object{
        private const val ITEM = "item"

        fun start(context: Context, item:Content?= null){
            Intent(context, InputActivity::class.java).apply {
                putExtra(ITEM,item)
            }.run {
                context.startActivity(this)
            }
        }
    }
}