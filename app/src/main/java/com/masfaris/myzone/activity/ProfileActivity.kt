package com.masfaris.myzone.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.masfaris.myzone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val actionbar = supportActionBar
        val name = intent.getStringExtra("name")

        actionbar!!.title = name
        actionbar.setDisplayHomeAsUpEnabled(true)

        val image = intent.getStringExtra("image")
        Picasso.get().load(image).into(profileImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}