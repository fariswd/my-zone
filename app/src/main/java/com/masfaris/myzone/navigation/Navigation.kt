package com.masfaris.myzone.navigation

import android.content.Context
import android.content.Intent
import com.masfaris.myzone.*

class Navigation () {
    fun navigate(
            context: Context,
            navString: String,
            navData: List<NavData> = listOf()) {

        when(navString){
            "Index" -> nav(context, "Index", navData)
            "Home" -> nav(context, "Home", navData)
            "Login" -> nav(context, "Login", navData)
            "Profile" -> nav(context, "Profile", navData)
        }

    }

    private fun nav(
            context: Context,
            navString: String,
            navData: List<NavData> = listOf()){

        when(navString){
            "Index" -> {
                val intent = Intent(context, MainActivity::class.java)
                start(context, intent, navData)
            }

            "Home" -> {
                val intent = Intent(context, DrawerActivity::class.java)
                start(context, intent, navData)
            }

            "Login" -> {
                val intent = Intent(context, LoginActivity::class.java)
                start(context, intent, navData)
            }

            "Profile" -> {
                val intent = Intent(context, ProfileActivity::class.java)
                start(context, intent, navData)
            }
        }

    }

    private fun start(context: Context, intent: Intent, navData: List<NavData>){
        for (e in navData) {
            intent.putExtra(e.key, e.value)
        }
        context.startActivity(intent)
    }

}

data class NavData(val key: String, val value: String?)