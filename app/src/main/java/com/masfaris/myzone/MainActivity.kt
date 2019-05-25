package com.masfaris.myzone

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.masfaris.myzone.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPrefs = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        if(sharedPrefs.getBoolean("IS_LOGIN", false)) {
            Navigation().navigate(this,"Home")
        } else {
            Navigation().navigate(this,"Login")
        }

        finish()
    }

}
