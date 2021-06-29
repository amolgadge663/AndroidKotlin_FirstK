package com.amolsoftwares.firstk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {

    val TAG: String = "Amol"

    lateinit var email_txt: EditText
    lateinit var pass_txt: EditText
    lateinit var login_btn: Button

    lateinit var email: String
    lateinit var passw: String

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    lateinit var signInBtn: SignInButton

    companion object {
        private const val RC_SIGN_IN = 120
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG", "onCreate is called")
        /*val makeText = Toast.makeText(this, "onCreate is called", Toast.LENGTH_SHORT)
        makeText.show()*/

        login_btn = findViewById(R.id.login_btn)
        email_txt = findViewById<EditText>(R.id.email)
        pass_txt = findViewById<EditText>(R.id.pass)

        login_btn.setOnClickListener {

            email = email_txt.text.toString()
            passw = pass_txt.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email should not be empty", Toast.LENGTH_SHORT).show()
            } else if (passw.isEmpty()) {
                Toast.makeText(this, "Password should not be empty $email", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Login Success...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name_s", email)
                startActivity(intent)
            }
        }

        //firebase auth
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if (user != null) {
            val intentD = Intent(this@MainActivity, DashboardActivity::class.java)
            startActivity(intentD)
            finish()
        }

        /*Handler().postDelayed({
            if (user != null) {
                val intentD = Intent(this@MainActivity, DashboardActivity::class.java)
                startActivity(intentD)
                finish()
            } else {
                val intentM = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intentM)
                finish()
            }
        }, 2000)*/

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        signInBtn = findViewById(R.id.sign_in_button)

        signInBtn.setOnClickListener {
            signIn()
        }

    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    Log.w(TAG, "Google sign in failed", e)
                }
            } else {
                Log.w(TAG, exception.toString())
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val intentD = Intent(this@MainActivity, DashboardActivity::class.java)
                    startActivity(intentD)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart is called")
        //Toast.makeText(this, "onStart is called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume is called")
        //Toast.makeText(this, "onResume is called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause is called")
        //Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG", "onPause is called")
        //Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG", "onPause is called")
        //Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show()
    }

    fun openFrag(view: View) {
        Toast.makeText(this, "you clicked on OpenFrag button", Toast.LENGTH_SHORT).show()
        val i = Intent(this, FragActivity::class.java)
        startActivity(i)
    }
}