package com.example.android_delivery_app.utils.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android_delivery_app.databinding.ViewholderEmptyBinding
import com.example.android_delivery_app.model.CellType
import com.example.android_delivery_app.model.Model
import com.example.android_delivery_app.screen.base.BaseViewModel
import com.example.android_delivery_app.utils.provider.ResourceProvider
import com.example.android_delivery_app.widget.adapter.viewholder.EmptyViewHolder
import com.example.android_delivery_app.widget.adapter.viewholder.ModelViewHolder


 object ModelViewHolderMapper {

    fun<M: Model> map(
        parent: ViewGroup,
        type:CellType,
        viewModel: BaseViewModel,
        resourceProvider: ResourceProvider
    ): ModelViewHolder<M>{
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when(type){
            CellType.EMPTY_CELL->{
                EmptyViewHolder(ViewholderEmptyBinding.inflate(inflater, parent, false),viewModel ,resourceProvider)
            }
        }
        return viewHolder as ModelViewHolder<M>
    }
}