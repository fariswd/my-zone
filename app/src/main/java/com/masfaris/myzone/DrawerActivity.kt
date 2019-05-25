package com.masfaris.myzone

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import com.masfaris.myzone.navigation.NavData
import com.masfaris.myzone.navigation.Navigation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_drawer.*

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val member = listOf<Member>(
            Member(0, "Kwon Eunbi", "https://uploads.disquscdn.com/images/2789274fb49d287435c25ecb3cf53950ef8ee0922336e1a3650595b6dcb16603.jpg?w=600&h=906"),
            Member(1, "Miyawaki Sakura", "https://uploads.disquscdn.com/images/dd6bb5b305d9f598787f0ae860c54bf0dbbd2650f74c17381b7874e507780068.jpg?w=600&h=893"),
            Member(2, "Kang Hyewon", "https://uploads.disquscdn.com/images/cf68f675ef42d86403f1044f221061ea2e0b251f5c8fc0e62f4157541e718cd5.jpg?w=600&h=893"),
            Member(3, "Choi Yena", "https://uploads.disquscdn.com/images/b26156ffe6ad97e55a388bc36cb081701178219b9b4c8896a2b8556b895becaf.jpg?w=600&h=893"),
            Member(4, "Lee Chaeyeon", "https://uploads.disquscdn.com/images/83a4431157ca733d765ae9ea906daad65160a69f46e40b49844c6647f5d76c9f.jpg?w=600&h=893"),
            Member(5, "Kim Chaewon", "https://uploads.disquscdn.com/images/2a5e54b36938b634e0214c83983f0f698a1b2d1a8b86dddb75b948798fe94b41.jpg?w=600&h"),
            Member(6, "Kim Minjoo", "https://kprofiles.com/wp-content/uploads/2018/09/Minju-1-614x800.jpg"),
            Member(7, "Yabuki Nako", "https://uploads.disquscdn.com/images/150d7e99743255b0b090e1c2883d55a365ec2ecd69ae9e8e33cefb00986cda50.jpg?w=600&h=893"),
            Member(8, "Honda Hitomi", "https://uploads.disquscdn.com/images/db960d49ac986fac77eac9007dcb2b0fd33833fbbf8a1139c2313b471c4b2e45.jpg?w=600&h=808"),
            Member(9, " Jo Yuri", "https://uploads.disquscdn.com/images/02fc8b9870b0b9ce250ee40ff5c9dab6d2ce06a5994210f04127a7e71206f00b.jpg?w=600&h=846"),
            Member(10, "Ahn Yujin", "https://uploads.disquscdn.com/images/b1b16c7c3d14b9fa7484dc1f0187d573ca68284ca64df4b2d977a4b5f17859c8.jpg?w=600&h=908"),
            Member(11, "Jang Wonyoung", "https://uploads.disquscdn.com/images/bf642838e736aef98d1c65b89fb584931062bf1383362ba828e727f5bd9b7805.jpg?w=600&h=893")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "My Zone"

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        showProfiles()
    }

    fun showProfiles(){
        Picasso.get().load(member[0].image).into(imageMember);
        nameMember.text = member[0].name
        imageMember.setOnClickListener {
            toProfiles(member[0].name, member[0].image)
        }

        Picasso.get().load(member[1].image).into(imageMember2);
        nameMember2.text = member[1].name
        imageMember2.setOnClickListener {
            toProfiles(member[1].name, member[1].image)
        }

        Picasso.get().load(member[2].image).into(imageMember3);
        nameMember3.text = member[2].name
        imageMember3.setOnClickListener {
            toProfiles(member[2].name, member[2].image)
        }

        Picasso.get().load(member[3].image).into(imageMember4);
        nameMember4.text = member[3].name
        imageMember4.setOnClickListener {
            toProfiles(member[3].name, member[3].image)
        }

        Picasso.get().load(member[4].image).into(imageMember5);
        nameMember5.text = member[4].name
        imageMember5.setOnClickListener {
            toProfiles(member[4].name, member[4].image)
        }

        Picasso.get().load(member[5].image).into(imageMember6);
        nameMember6.text = member[5].name
        imageMember6.setOnClickListener {
            toProfiles(member[5].name, member[5].image)
        }

        Picasso.get().load(member[6].image).into(imageMember7);
        nameMember7.text = member[6].name
        imageMember7.setOnClickListener {
            toProfiles(member[6].name, member[6].image)
        }

        Picasso.get().load(member[7].image).into(imageMember8);
        nameMember8.text = member[7].name
        imageMember8.setOnClickListener {
            toProfiles(member[7].name, member[7].image)
        }

        Picasso.get().load(member[8].image).into(imageMember9);
        nameMember9.text = member[8].name
        imageMember9.setOnClickListener {
            toProfiles(member[8].name, member[8].image)
        }


        Picasso.get().load(member[9].image).into(imageMember10);
        nameMember10.text = member[9].name
        imageMember10.setOnClickListener {
            toProfiles(member[9].name, member[9].image)
        }

        Picasso.get().load(member[10].image).into(imageMember11);
        nameMember11.text = member[10].name
        imageMember11.setOnClickListener {
            toProfiles(member[10].name, member[10].image)
        }

        Picasso.get().load(member[11].image).into(imageMember12);
        nameMember12.text = member[11].name
        imageMember12.setOnClickListener {
            toProfiles(member[11].name, member[11].image)
        }
    }

    fun toProfiles(name: String, image: String) {
        Navigation().navigate(this, "Profile", listOf<NavData>(
                NavData("name", name),
                NavData("image", image)
        ))
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_logout -> logout()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun logout() {
        val sharedPrefs = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.remove("IS_LOGIN")
        editor.commit()

        Navigation().navigate(this,"Index")
        finish()
    }

    data class Member(
            val id: Int,
            val name: String,
            val image: String
    )
}
