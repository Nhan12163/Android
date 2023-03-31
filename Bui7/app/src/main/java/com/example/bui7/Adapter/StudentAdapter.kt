package com.example.bui7.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bui7.Model.Student
import com.example.bui7.R
import com.example.bui7.UpdateView

class StudentAdapter :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    private var students: List<Student> = listOf()
    fun setStudents(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
        holder.itemView.setOnClickListener{
            var i = Intent(holder.itemView.context, UpdateView::class.java)

            i.putExtra("id",student.id)
            i.putExtra("name", student.name)
            i.putExtra("email", student.email)
            i.putExtra("sdt", student.phone)
            holder.itemView.context.startActivity(i)
        }
    }
    override fun getItemCount(): Int = students.size
    inner class StudentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView =
            itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView =
            itemView.findViewById(R.id.emailTextView)
        private val phoneTextView: TextView =
            itemView.findViewById(R.id.phoneTextView)
        fun bind(student: Student) {
            nameTextView.text = student.name
            emailTextView.text = student.email
            phoneTextView.text = student.phone
        }
    }
}