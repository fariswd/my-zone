package com.masfaris.myzone

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val actionbar = supportActionBar
        actionbar!!.title = "Profile Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
//        println(message)
        profileText.text = message
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}