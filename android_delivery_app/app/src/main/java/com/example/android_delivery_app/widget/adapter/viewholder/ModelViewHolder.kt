package com.example.android_delivery_app.widget.adapter.viewholder

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.android_delivery_app.model.Model
import com.example.android_delivery_app.screen.base.BaseViewModel
import com.example.android_delivery_app.utils.provider.ResourceProvider
import com.example.android_delivery_app.widget.adapter.listener.AdapterListener

/**
 * viewholder의  추상클래스
 * */
abstract class ModelViewHolder<M : Model>(
    binding: ViewBinding,
    protected open val viewModel: BaseViewModel,
    protected open val resourceProvider: ResourceProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M){
        reset()
    }

    abstract fun bindViews(model:M, adapterListener: AdapterListener)
}