package com.example.recyclerview.data

import com.example.recyclerview.Model.testimage
import com.example.recyclerview.R

class Datasource {
    fun loadAffirmations(): List<testimage> {
        return listOf<testimage>(
            testimage(R.string.t1,R.drawable.luffy1),
            testimage(R.string.t2,R.drawable.luffy2),
            testimage(R.string.t3,R.drawable.luffy3),
            testimage(R.string.t4,R.drawable.luffy4)

        )
    }
}