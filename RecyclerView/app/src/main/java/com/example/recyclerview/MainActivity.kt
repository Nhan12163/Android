package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.Itemadapter
import com.example.recyclerview.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadAffirmations()
        val recyclerView =
            findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = Itemadapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}