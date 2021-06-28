package com.amolsoftwares.firstk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    private lateinit var idTxt: TextView
    private lateinit var nameTxt: TextView
    private lateinit var emailTxt: TextView
    private lateinit var image: ImageView
    private lateinit var signOutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        idTxt = findViewById(R.id.id_txt)
        nameTxt = findViewById(R.id.name_txt)
        emailTxt = findViewById(R.id.email_txt)
        image = findViewById(R.id.profile_image)
        signOutBtn = findViewById(R.id.sign_out_btn)

        idTxt.text = currentUser?.uid
        nameTxt.text = currentUser?.displayName
        emailTxt.text = currentUser?.email

        Glide.with(this).load(currentUser?.photoUrl).into(image)

        signOutBtn.setOnClickListener {
            mAuth.signOut()
            val intentOut = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intentOut)
            finish()
        }

    }
}