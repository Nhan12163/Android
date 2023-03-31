package com.example.bui7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bui7.Adapter.StudentAdapter
import com.example.bui7.Model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private lateinit var adapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var btnadd:Button
    lateinit var btnsearch:Button
    lateinit var edtsearch:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnadd = findViewById(R.id.btnviewadd)
        btnsearch = findViewById(R.id.btnsearch)
        edtsearch = findViewById(R.id.edtsearch)
        adapter = StudentAdapter()
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
        btnadd.setOnClickListener { insertView() }
        btnsearch.setOnClickListener { search() }

    }
    private fun loadData() {
        val studentApi = RetrofitClient.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = studentApi.getStudents()
            val students = gson.fromJson<List<Student>>(response.string(),
                object : TypeToken<List<Student>>() {}.type)
            withContext(Dispatchers.Main) {
                adapter.setStudents(students)
            }
        }
    }
    private fun insertView(){
        var i = Intent(this, InsertStudent::class.java)
        startActivity(i)
    }
    private fun search() {
        val name = edtsearch.text.toString()
        val student = Student( null, name, null, null)
        val studentApi = RetrofitClient.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = studentApi.getSearch(student)
            val students = gson.fromJson<List<Student>>(response.string(),
                object : TypeToken<List<Student>>() {}.type)
            withContext(Dispatchers.Main) {
                adapter.setStudents(students)
            }
        }
    }
}