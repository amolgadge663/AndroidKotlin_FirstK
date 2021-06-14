package com.amolsoftwares.firstk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /*lateinit var str_email: String
    lateinit var str_pass: String*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG","onCreate is called")
        val makeText = Toast.makeText(this, "onCreate is called", Toast.LENGTH_SHORT)
        makeText.show()

        /*val login_btn = findViewById<Button>(R.id.login_btn)
        val email_txt = findViewById<EditText>(R.id.email).text.toString()
        val pass_txt = findViewById<EditText>(R.id.pass).text.toString()*/

        /*str_email = email_txt.text.toString()
        str_pass = pass_txt.text.toString()*/

        login_btn.setOnClickListener {
            if (email_txt.isBlank() && pass_txt.isBlank())
                Toast.makeText(this, "Login Button Click", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG","onStart is called")
        Toast.makeText(this, "onStart is called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG","onResume is called")
        Toast.makeText(this, "onResume is called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG","onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG","onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG","onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }
}