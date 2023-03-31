package com.example.buoi7_2.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi7_2.Model.Marvel
import com.example.buoi7_2.R

class MarvelAdapter :
    RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {
    private var marvels: List<Marvel> = listOf()
    fun setMarvels(marvels: List<Marvel>) {
        this.marvels = marvels
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MarvelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MarvelViewHolder(view)
    }
    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        val marvel = marvels[position]
        holder.bind(marvel)
    }
    override fun getItemCount(): Int = marvels.size
    inner class MarvelViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvnamehero: TextView =
            itemView.findViewById(R.id.namehero)
        private val tvrealnamehero: TextView =
            itemView.findViewById(R.id.realnamehero)
        fun bind(marvel: Marvel) {
            tvnamehero.text = marvel.name
            tvrealnamehero.text = marvel.realnamename

        }
    }
}