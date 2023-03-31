package com.example.thigk2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thigk2.Apdater.GKAdapter
import com.example.thigk2.Model.GK
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private lateinit var adapter: GKAdapter
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = GKAdapter()
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
    }
    fun loadData() {
        val gkApi  = RetrofitClient.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = gkApi.getgk()
            val gks = gson.fromJson<List<GK>>(response.string(),
                object : TypeToken<List<GK>>() {}.type)
            withContext(Dispatchers.Main) {
                adapter.setMarvels(gks)
            }
        }
    }
    }