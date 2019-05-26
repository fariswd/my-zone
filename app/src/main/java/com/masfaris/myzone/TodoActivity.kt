package com.masfaris.myzone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val actionbar = supportActionBar
        actionbar!!.title = "Todo"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
