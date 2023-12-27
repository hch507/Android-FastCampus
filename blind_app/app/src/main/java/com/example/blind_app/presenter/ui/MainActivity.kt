package com.example.blind_app.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.blind_app.R
import com.example.blind_app.databinding.ActivityMainBinding
import com.example.blind_app.domain.model.Content
import com.example.blind_app.presenter.ui.list.ListAdapter
import com.example.blind_app.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter by lazy { ListAdapter(Handler()) }
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(binding.root)
            view=this@MainActivity
            recyclerView.adapter =adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL)
            )

        }
        observeViewModel()
    }
    fun onClickAdd(){
        InputActivity.start(context = this)
    }
    fun observeViewModel(){
        lifecycleScope.launch {
            viewModel.contentList
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collectLatest {
                    binding.apply {
                        progressBar.isVisible= false
                        emptyTextView.isVisible= it.isEmpty()
                        recyclerView.isVisible=it.isNotEmpty()
                    }
                    adapter.submitList(it)
                }
        }
    }
    inner class Handler{
        fun onClickItem(item : Content){
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClickItem(item: Content):Boolean{
            AlertDialog.Builder(this@MainActivity)
                .setTitle("정말 삭제하시겠습니까?")
                .setPositiveButton("네"){
                    _, _ ->
                }
                .setNegativeButton("아니요"){
                    _,_ ->
                }
                .show()
            return false
        }
    }
}