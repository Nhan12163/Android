package com.example.thigk2.Apdater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thigk2.Model.GK
import com.example.thigk2.R

class GKAdapter :
    RecyclerView.Adapter<GKAdapter.MarvelViewHolder>() {
    private var gks: List<GK> = listOf()
    fun setMarvels(marvels: List<GK>) {
        this.gks = marvels
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MarvelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MarvelViewHolder(view)
    }
    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        val marvel = gks[position]
        holder.bind(marvel)
    }
    override fun getItemCount(): Int = gks.size
    inner class MarvelViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvuserid: TextView =
            itemView.findViewById(R.id.userid)
        private val tvid: TextView =
            itemView.findViewById(R.id.id)
        private val tvtitle: TextView =
            itemView.findViewById(R.id.title)
        private val tvcompleted: TextView =
            itemView.findViewById(R.id.completed)
        fun bind(gk: GK) {
            tvuserid.text = gk.userId.toString()
            tvid.text = gk.id.toString()
            tvtitle.text = gk.title.toString()
            tvcompleted.text = gk.completed.toString()

        }
    }
}