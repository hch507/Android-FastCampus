package com.example.android_delivery_app.screen.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

/**
 * state와 view의 초기화를 다른 함수로 둠
 * */
abstract class BaseFragmnet<VM : BaseViewModel, VB : ViewBinding> : Fragment() {
    abstract val viewModel: VM
    protected lateinit var binding: VB

    private lateinit var fetchJob: Job

    abstract fun getViewBinding() : VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initState()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initState()

    }

    open fun initState() {
        arguments?.let {
            viewModel.storeState(it)
        }
        initViews()
        fetchJob = viewModel.fetchData()
    }

    open fun initViews() = Unit

    abstract fun obserData()

    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()

    }
}