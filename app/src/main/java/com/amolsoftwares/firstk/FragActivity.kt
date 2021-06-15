package com.amolsoftwares.firstk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class FragActivity : AppCompatActivity() {

    lateinit var fr1: Button
    lateinit var fr2: Button
    lateinit var fr3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)

        fr1 = findViewById(R.id.frag1)
        fr2 = findViewById(R.id.frag2)
        fr3 = findViewById(R.id.frag3)

        fr1.setOnClickListener {
            Toast.makeText(this, "frg 1", Toast.LENGTH_SHORT).show()
        }

        fr2.setOnClickListener {
            Toast.makeText(this, "frg 2", Toast.LENGTH_SHORT).show()
        }

        fr3.setOnClickListener {
            Toast.makeText(this, "frg 3", Toast.LENGTH_SHORT).show()
        }
    }
}