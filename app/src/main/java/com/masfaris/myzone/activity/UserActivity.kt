package com.masfaris.myzone.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.masfaris.myzone.api.GetData
import com.masfaris.myzone.R
import com.masfaris.myzone.model.UserModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserActivity : AppCompatActivity() {

    val BASE_URL = "https://jsonplaceholder.typicode.com"
    private var myCompositeDisposable: CompositeDisposable? = null
    private var myUserList: ArrayList<UserModel>? = null
    private var myAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val actionbar = supportActionBar
        actionbar!!.title = "User"
        actionbar.setDisplayHomeAsUpEnabled(true)

        myCompositeDisposable = CompositeDisposable()

        loadData()
    }

    fun loadData() {
        val requestInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(GetData::class.java)

        myCompositeDisposable?.add(requestInterface.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse))
    }

    fun handleResponse(userData: ArrayList<UserModel>) {
        myUserList = ArrayList<UserModel>(userData)
        println("userdata ===== $myUserList")

        myAdapter = UserAdapter(ArrayList<UserModel>(userData))
        userView.layoutManager = LinearLayoutManager(this)
        userView.adapter = myAdapter

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        myCompositeDisposable?.clear()
    }
}

class UserAdapter(var users: ArrayList<UserModel>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserAdapter.ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.user_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(p0: UserAdapter.ViewHolder, p1: Int) {
        p0.name.text = users[p1].name
        p0.userid.text = users[p1].id.toString()
        p0.email.text = users[p1].email
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.userName)
        val email: TextView = itemView.findViewById(R.id.userEmail)
        val userid: TextView = itemView.findViewById(R.id.userId)
    }

}