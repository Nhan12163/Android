package com.example.buoi8_framgment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.buoi8_framgment.BlankFragment3.Companion.newInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        val fragmentDemo = newInstance("Fragment", "Android")
        ft.replace(R.id.your_placeholder1, fragmentDemo)


        ft.replace(R.id.your_placeholder2, BlankFragment4())

        ft.commit()

    }
}