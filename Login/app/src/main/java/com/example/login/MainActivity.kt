package com.example.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

class MainActivity : AppCompatActivity() {

    var helloWorld: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeToLogin()
    }

    fun changeToLogin(){
        var intent = Intent(this, Login2Activity::class.java)

        Handler().postDelayed({
            intent.changed()
        }, 2000)
    }

    fun Intent.changed(){
        startActivity(this)
        finish()
    }
}
