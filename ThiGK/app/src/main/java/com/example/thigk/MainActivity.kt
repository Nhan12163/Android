package com.example.thigk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thigk.ContactAdapter.ctAdapter
import com.example.thigk.DB.DBHelper
import com.example.thigk.Model.ConTact

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ctAdapter
    lateinit var db:DBHelper
    lateinit var rvc: RecyclerView
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this, null)
        var contactArraylist: ArrayList<ConTact>
        contactArraylist = db!!.readCourse()!!

        rvc = findViewById<RecyclerView>(R.id.rev)

        val linearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvc.setLayoutManager (linearLayoutManager)
        rvc.adapter = ctAdapter(this, contactArraylist)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addcontact ->{
                var i = Intent(this, AddNew::class.java)
                startActivity(i)
                return (true)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}