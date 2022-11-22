package com.example.company_application

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_projects.*


class ProjectsActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter;

        listItems.add("gfjk;'d")
        adapter.notifyDataSetChanged()
    }


}