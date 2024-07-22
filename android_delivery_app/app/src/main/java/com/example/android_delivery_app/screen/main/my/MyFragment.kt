package com.example.android_delivery_app.screen.main.my

import androidx.fragment.app.viewModels
import com.example.android_delivery_app.databinding.FragmentHomeBinding
import com.example.android_delivery_app.databinding.FragmentMyBinding
import com.example.android_delivery_app.screen.base.BaseFragmnet
import com.example.android_delivery_app.screen.base.BaseViewModel
import com.example.android_delivery_app.screen.main.home.HomeFragment

class MyFragment : BaseFragmnet<MyViewModel, FragmentMyBinding>() {
    override val viewModel: MyViewModel by viewModels()
    override fun getViewBinding(): FragmentMyBinding {
       return FragmentMyBinding.inflate(layoutInflater)
    }

    override fun obserData() {
        TODO("Not yet implemented")
    }

    companion object{
        fun newInstance() = MyFragment()
        const val TAG ="MyFragment"
    }
}