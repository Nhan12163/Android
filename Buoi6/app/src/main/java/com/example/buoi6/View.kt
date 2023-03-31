package com.example.buoi6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi6.Adapter.CourseRVAdapter

class View : AppCompatActivity() {
    lateinit var res: CourseRepository
    lateinit var adapter: CourseRVAdapter
    lateinit var rvCourses: RecyclerView
    lateinit var edtSearch:EditText
    lateinit var btnSearch:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        edtSearch = findViewById(R.id.edtsearch)
        btnSearch = findViewById(R.id.btnsearch)

        res = CourseRepository(application)
        var data: List<Course> = res.getAll() as List<Course>
        val courseArrayList: ArrayList<Course> = ArrayList()
        for (i in 0 until data.size) {
            val name: String = data.get(i).courseName
            val des: String = data.get(i).courseDecription
            val dur: String = data.get(i).courseDuration
            courseArrayList.add(Course(name, des, dur))
        }
        rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvCourses.setLayoutManager(linearLayoutManager)
        rvCourses.adapter = CourseRVAdapter(this, courseArrayList)

        btnSearch.setOnClickListener {
            var Namecourse = edtSearch.text.toString()
            if(Namecourse.isEmpty()){
                Toast.makeText(application, "Bạn vui lòng điền tên cần tìm", Toast.LENGTH_SHORT).show()
            }else {
                var data: List<Course> =
                    res.getSearchCourses(edtSearch.text.toString()) as List<Course>
                val courseArrayList: ArrayList<Course> = ArrayList()
                for (i in 0 until data.size) {
                    val name: String = data.get(i).courseName
                    val des: String = data.get(i).courseDecription
                    val dur: String = data.get(i).courseDuration
                    courseArrayList.add(Course(name, des, dur))
                }
                rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
                val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                rvCourses.setLayoutManager(linearLayoutManager)
                rvCourses.adapter = CourseRVAdapter(this, courseArrayList)
            }
        }

    }
}