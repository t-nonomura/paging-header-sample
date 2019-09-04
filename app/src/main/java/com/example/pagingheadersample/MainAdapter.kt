package com.example.pagingheadersample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : PagedListAdapter<Item, MainAdapter.ItemViewHolder>(ItemCallback) {

    private object ItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return when {
                oldItem is Header && newItem is Header -> oldItem.id == newItem.id
                oldItem is Body && newItem is Body -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return when {
                oldItem is Header && newItem is Header -> oldItem.shopName == newItem.shopName
                oldItem is Body && newItem is Body -> oldItem.commodityName == newItem.commodityName
                else -> false
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (super.getItem(position)) {
            is Header -> 1
            is Body -> 2
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutRes = when (viewType) {
            1 -> R.layout.list_item_header
            2 -> R.layout.list_item_body
            else -> 0
        }
        val view = inflater.inflate(layoutRes, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        when (val model = getItem(position)) {
            is Header -> (holder.itemView as HeaderLayout).setContent(model)
            is Body -> (holder.itemView as BodyLayout).setContent(model)
        }
    }

    fun getHeaderItem(position: Int): Header {
        Log.d("nono", "header: ${getItem(position) as Header}")
        return getItem(position) as Header
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}