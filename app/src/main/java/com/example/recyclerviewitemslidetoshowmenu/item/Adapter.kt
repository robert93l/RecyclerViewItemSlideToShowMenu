package com.example.recyclerviewitemslidetoshowmenu.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewitemslidetoshowmenu.R

class Adapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var list = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.index = list[position]
        holder.onDeleteClick = {
            removeItem(it)
        }
        holder.updateView()
    }

    fun reload(list: List<Int>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun removeItem(viewHolder: RecyclerView.ViewHolder) {

        val position = viewHolder.adapterPosition

        //remove data
        list.removeAt(position)

        //remove item
        notifyItemRemoved(position)
    }


}

