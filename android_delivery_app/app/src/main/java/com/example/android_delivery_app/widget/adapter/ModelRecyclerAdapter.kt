package com.example.android_delivery_app.widget.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android_delivery_app.model.CellType
import com.example.android_delivery_app.model.Model
import com.example.android_delivery_app.screen.base.BaseViewModel

import com.example.android_delivery_app.utils.mapper.ModelViewHolderMapper
import com.example.android_delivery_app.utils.provider.ResourceProvider
import com.example.android_delivery_app.widget.adapter.listener.AdapterListener
import com.example.android_delivery_app.widget.adapter.viewholder.ModelViewHolder

/**
 * 공통의 리사이클러뷰 어댑터
 *
 * */
class ModelRecyclerAdapter<M : Model, VM : BaseViewModel>(
    private var modelList : List<Model>,
    private var viewModel : VM,
    private val resourceProvider: ResourceProvider,
    private val adapterListener: AdapterListener
) : ListAdapter<Model, ModelViewHolder<M>>(Model.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder<M> {
        return ModelViewHolderMapper.map(parent, CellType.values()[viewType], viewModel ,resourceProvider)
    }

    override fun onBindViewHolder(holder: ModelViewHolder<M>, position: Int) {
        with(holder){
            bindData(modelList[position] as M)
            bindViews(modelList[position] as M, adapterListener)
        }
    }

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int): Int {
        return modelList[position].type.ordinal
    }

    override fun submitList(list: MutableList<Model>?) {
        list?.let {
            modelList =it
        }
        super.submitList(list)
    }

}