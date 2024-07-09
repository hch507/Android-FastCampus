package com.example.android_delivery_app.widget.adapter.viewholder

import com.example.android_delivery_app.databinding.ViewholderEmptyBinding
import com.example.android_delivery_app.model.Model
import com.example.android_delivery_app.screen.base.BaseViewModel
import com.example.android_delivery_app.utils.provider.ResourceProvider
import com.example.android_delivery_app.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding : ViewholderEmptyBinding,
    viewModel: BaseViewModel,
    resourceProvider: ResourceProvider
) : ModelViewHolder<Model>(binding, viewModel, resourceProvider) {
    override fun reset() = Unit
    override fun bindViews(model: Model, adapterListener: AdapterListener) = Unit
}