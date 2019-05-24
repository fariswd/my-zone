package com.masfaris.myzone

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View

const val EXTRA_MESSAGE = "com.masfaris.myzone.MESSAGE"


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionbar = supportActionBar
        actionbar!!.title = "Home Activity"
    }


    fun toProfile(view: View) {
        val message = "Hi from Home"
        val intent = Intent(this, ProfileActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}