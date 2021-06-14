package com.amolsoftwares.firstk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var email_txt: EditText
    lateinit var pass_txt: EditText
    lateinit var login_btn: Button

    lateinit var email: String
    lateinit var passw: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG", "onCreate is called")
        val makeText = Toast.makeText(this, "onCreate is called", Toast.LENGTH_SHORT)
        makeText.show()

        login_btn = findViewById(R.id.login_btn)
        email_txt = findViewById<EditText>(R.id.email)
        pass_txt = findViewById<EditText>(R.id.pass)

        login_btn.setOnClickListener {

            email = email_txt.text.toString()
            passw = pass_txt.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email should not be empty", Toast.LENGTH_SHORT).show()
            } else if (passw.isEmpty()) {
                Toast.makeText(this, "Password should not be empty", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart is called")
        Toast.makeText(this, "onStart is called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume is called")
        Toast.makeText(this, "onResume is called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG", "onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG", "onPause is called")
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }
}