package com.amolsoftwares.firstk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tv_name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv_name = findViewById(R.id.name)

        val str = intent.getStringExtra("name_s")
        tv_name.text = str
    }
}