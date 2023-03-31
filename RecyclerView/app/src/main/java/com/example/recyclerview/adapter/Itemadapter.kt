package com.example.recyclerview.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.testimage
import com.example.recyclerview.R

class Itemadapter(
private val context: Context,
private val dataset: List<testimage>
) : RecyclerView.Adapter<Itemadapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    var imageView: ImageView = view.findViewById(R.id.image_hero)
    val textView: TextView = view.findViewById(R.id.text_name)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): Itemadapter.ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)
        return Itemadapter.ItemViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: Itemadapter.ItemViewHolder,
                                  position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.name)
        holder.imageView.setImageResource(item.image)

    }
    override fun getItemCount() = dataset.size
}

