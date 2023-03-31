package com.example.thigk.ContactAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thigk.Model.ConTact
import com.example.thigk.R

class ctAdapter (
    private val context: Context,
    private val contactArraylist: ArrayList<ConTact>
): RecyclerView.Adapter<ctAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View):
        RecyclerView.ViewHolder(view){
        val tvName: TextView? = view.findViewById(R.id.tvname)
        val tvPhone: TextView? = view.findViewById(R.id.tvphone)
        val tvEmail: TextView? = view.findViewById(R.id.tvemail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(adapterLayout)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val modal: ConTact = contactArraylist.get(position)
        holder.tvName!!.text = modal.getName()
        holder.tvPhone!!.text=modal.getPhone()
        holder.tvEmail!!.text = modal.getEmail()

    }
    override fun getItemCount() = contactArraylist.size
}