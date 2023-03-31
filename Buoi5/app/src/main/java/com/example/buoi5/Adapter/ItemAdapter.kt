package com.example.buoi5.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi5.Entity.Course
import com.example.buoi5.R
import com.example.buoi5.UpdateCourse

class ItemAdapter(
    private val context:Context,
    private val courseArraylist: ArrayList<Course>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View):
        RecyclerView.ViewHolder(view){
        val tvCourseName: TextView? = view.findViewById(R.id.name)
        val tvCourseDecription: TextView? = view.findViewById(R.id.decription)
        val tvDuration: TextView? = view.findViewById(R.id.duration)
        val tvTrack: TextView? = view.findViewById(R.id.track)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
        return ItemViewHolder(adapterLayout)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val modal: Course = courseArraylist.get(position)
        holder.tvCourseName!!.text = modal.getCourseName()
        holder.tvCourseDecription!!.text=modal.getCourseDecription()
        holder.tvDuration!!.text = modal.getCourseDuration()
        holder.tvTrack!!.text = modal.getCourseTrack()

        holder.itemView.setOnClickListener{
                val i = Intent(context, UpdateCourse::class.java)
              i.putExtra("name", modal.getCourseName())
              i.putExtra("decription", modal.getCourseDecription())
              i.putExtra("duration", modal.getCourseDuration())
              i.putExtra("track", modal.getCourseTrack())
              context.startActivity(i)
        }
    }
    override fun getItemCount() = courseArraylist.size
}