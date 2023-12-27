package com.example.blind_app.presenter.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.blind_app.databinding.ItemContentBinding
import com.example.blind_app.domain.model.Content
import com.example.blind_app.presenter.ui.MainActivity
import com.example.blind_app.presenter.ui.list.viewholder.ContentViewHolder

class ListAdapter(
    private val handler: MainActivity.Handler
): androidx.recyclerview.widget.ListAdapter<Content,ContentViewHolder>(diffCallback){
    companion object{
        private  val diffCallback= object : DiffUtil.ItemCallback<Content>(){
            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            handler
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}