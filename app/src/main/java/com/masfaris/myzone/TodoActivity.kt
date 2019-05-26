package com.masfaris.myzone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.masfaris.myzone.model.TodoModel
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {

    var todoList = mutableListOf<TodoModel>()
    var adapter: TodoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val actionbar = supportActionBar
        actionbar!!.title = "Todo"
        actionbar.setDisplayHomeAsUpEnabled(true)

        todoStart()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun todoStart() {
        adapter = TodoAdapter(todoList)
        todoView.layoutManager = LinearLayoutManager(this)
        todoView.adapter = adapter
    }


    fun addTodo(view: View) {
        var titleTxt = addTitleTodo.text
        adapter!!.insertData(TodoModel(titleTxt.toString(), false))
        addTitleTodo.text.clear()
    }

}

class TodoAdapter(var todos: MutableList<TodoModel>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TodoAdapter.ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.todo_single_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(p0: TodoAdapter.ViewHolder, p1: Int) {
        p0.title.text = todos[p1].title
        p0.status.isChecked = todos[p1].status
        p0.status.setOnClickListener {
            var index = -1
            for(i in todos.indices){
                if(todos[i].title == todos[p1].title) {
                    index = i
                }
            }
            updateData(index, TodoModel(todos[p1].title, !todos[p1].status))
        }
        p0.deleteTodo.setOnClickListener {
            var index = -1
            for(i in todos.indices){
                if(todos[i].title == todos[p1].title) {
                    index = i
                }
            }
            deleteData(index)

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val status: CheckBox = itemView.findViewById(R.id.statusBoxs)
        val deleteTodo: ImageView = itemView.findViewById(R.id.deleteTodo)
    }

    fun insertData(newList: TodoModel) {
        todos.add(newList)
        this.notifyDataSetChanged()
    }

    fun updateData(index: Int, newList: TodoModel) {
        todos.set(index, newList)
        this.notifyDataSetChanged()
    }

    fun deleteData(index: Int) {
        todos.removeAt(index)
        this.notifyDataSetChanged()
    }

}