package com.example.buoi6.Adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi6.*

class CourseRVAdapter(
    private val context: Context,
    private val courseArrayList: ArrayList<Course>
) : RecyclerView.Adapter<CourseRVAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        val tvCourseName: TextView =
            view.findViewById(R.id.tvCourseName)
        val tvCourseDescription: TextView =
            view.findViewById(R.id.tvCourseDescription)
        val tvCourseDuration: TextView =
            view.findViewById(R.id.tvCourseDuration)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.course_item
                , parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder,
                                  position: Int) {
        val modal: Course = courseArrayList.get(position)
        holder.tvCourseName.text = modal.courseName
        holder.tvCourseDescription.text = modal.courseDecription
        holder.tvCourseDuration.text = modal.courseDuration
        // add on click listener for our recycler view item.

        holder.itemView.setOnClickListener {
            var i = Intent(context, UpdateView::class.java)

          //  i.putExtra("id", db.myDao().getIdByName(modal.courseName))
            i.putExtra("name", modal.courseName)
            i.putExtra("decription", modal.courseDecription)
            i.putExtra("duration", modal.courseDuration)
            context.startActivity(i)
        }
    }
    override fun getItemCount() = courseArrayList.size
}
