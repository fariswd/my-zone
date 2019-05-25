package com.masfaris.myzone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.masfaris.myzone.navigation.Navigation

class LoginActivity : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        val actionbar = supportActionBar
//        actionbar!!.title = "Login Activity"

    }

    fun toHome(view: View) {
        val sharedPrefs = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putBoolean("IS_LOGIN", true)
        editor.commit()

        Navigation().navigate(this, "Home")
        finish()
    }


}