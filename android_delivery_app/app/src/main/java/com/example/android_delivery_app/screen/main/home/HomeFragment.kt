package com.example.android_delivery_app.screen.main.home

import androidx.fragment.app.viewModels
import com.example.android_delivery_app.databinding.FragmentHomeBinding
import com.example.android_delivery_app.screen.base.BaseFragmnet
import com.example.android_delivery_app.screen.base.BaseViewModel

class HomeFragment : BaseFragmnet<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()
    override fun getViewBinding(): FragmentHomeBinding {
       return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun obserData() {
        TODO("Not yet implemented")
    }
    companion object{
        fun newInstance() = HomeFragment()
        const val TAG ="HomeFragment"
    }
}