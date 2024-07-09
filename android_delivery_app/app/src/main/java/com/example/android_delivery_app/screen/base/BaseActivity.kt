package com.example.android_delivery_app.screen.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

/**
 * state와 view의 초기화를 다른 함수로 둠
 *
 * */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {
    abstract val viewModel: VM
    protected lateinit var binding: VB

    private lateinit var fetchJob: Job

    abstract fun getViewBinding() : VB
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = getViewBinding()
        setContentView(binding.root)
        initState()

    }

    open fun initState() {
        fetchJob = viewModel.fetchData()
        initViews()
    }

    open fun initViews() = Unit

    abstract fun observeData()

    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()

    }
}