package com.example.company_application.view.project

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import com.example.company_application.view.report.ReportDetailActivity
import kotlinx.android.synthetic.main.activity_projects.*


class ProjectsActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        project_listView.adapter = adapter;

        listItems.add("Проект 1")
        listItems.add("Проект 2")
        adapter.notifyDataSetChanged()

        project_add.setOnClickListener{
            val intent = Intent(this, ProjectAddActivity::class.java)
            startActivity(intent)
        }

        project_listView.setOnItemClickListener { parent, view, position, id ->
            val element = view as TextView
            val data = element.text.toString()

            val intent = Intent(this, ProjectDetailActivity::class.java)
            intent.putExtra("projectData", data)
            startActivity(intent)

        }
    }


}