package com.example.buoi7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi7_2.Adapter.MarvelAdapter
import com.example.buoi7_2.Model.Marvel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private lateinit var adapter: MarvelAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MarvelAdapter()
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
    }
    fun loadData() {
        val marvelApi  = RetrofitClient.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = marvelApi.getsuperHeroes()
            val marvels = gson.fromJson<List<Marvel>>(response.string(),
                object : TypeToken<List<Marvel>>() {}.type)
            withContext(Dispatchers.Main) {
                adapter.setMarvels(marvels)
            }
        }
    }



}