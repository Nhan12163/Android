package com.example.buoi5

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.textclassifier.SelectionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi5.Adapter.ItemAdapter
import com.example.buoi5.DB.DBHelper
import com.example.buoi5.Entity.Course
import java.util.jar.Attributes


class Display : AppCompatActivity() {
    lateinit var db: DBHelper
    lateinit var adapter: ItemAdapter
    lateinit var rvCourses: RecyclerView
    lateinit var edtsearch:EditText
    lateinit var btnsearch:Button
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        edtsearch = findViewById(R.id.edtsearch)
        btnsearch = findViewById(R.id.btnsearch)

        db = DBHelper(this, null)
        var courseArraylist: ArrayList<Course>
        courseArraylist = db!!.readCourse()!!

        rvCourses = findViewById<RecyclerView>(R.id.rev)

        val linearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvCourses.setLayoutManager (linearLayoutManager)
            rvCourses.adapter = ItemAdapter(this, courseArraylist)

        btnsearch.setOnClickListener{
            Searchcourse()
        }
    }
    fun Searchcourse(){
        var Namecourse = edtsearch.text.toString()

        if(Namecourse.isEmpty()){
            Toast.makeText(application, "Bạn vui lòng điền tên cần tìm", Toast.LENGTH_SHORT).show()
        }else{
            var courseArraylist: ArrayList<Course>
            courseArraylist = db!!.search(Namecourse)!!

            rvCourses = findViewById<RecyclerView>(R.id.rev)

            val linearLayoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvCourses.setLayoutManager (linearLayoutManager)
            rvCourses.adapter = ItemAdapter(this, courseArraylist)
        }
    }

}