package com.masfaris.myzone

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPrefs = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        if(sharedPrefs.getBoolean("IS_LOGIN", false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        finish()
    }

}
