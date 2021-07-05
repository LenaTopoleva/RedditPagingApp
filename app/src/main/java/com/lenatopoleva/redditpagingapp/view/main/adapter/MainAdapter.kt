package com.lenatopoleva.redditpagingapp.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lenatopoleva.redditpagingapp.databinding.ActivityMainRecyclerviewItemBinding
import com.lenatopoleva.redditpagingapp.model.data.Child
import com.lenatopoleva.redditpagingapp.model.data.ChildData
import com.lenatopoleva.redditpagingapp.model.data.DataModel


class MainAdapter(private var onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    private lateinit var data: DataModel

    fun setData(data: DataModel) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = ActivityMainRecyclerviewItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data.data.children[position])
    }

    override fun getItemCount(): Int {
        return data.data.children.size
    }

    inner class RecyclerItemViewHolder(private var item: ActivityMainRecyclerviewItemBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(data: Child) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                item.headerTextviewRecyclerItem.text = data.data.title
                item.descriptionTextviewRecyclerItem.text = data.data.author
                item.root.setOnClickListener { onListItemClicked(data.data) }
            }
        }
    }

    private fun onListItemClicked(listItemData: ChildData) {
        onListItemClickListener.onItemClick(listItemData)
    }

    interface OnListItemClickListener {
        fun onItemClick(data: ChildData)
    }
}