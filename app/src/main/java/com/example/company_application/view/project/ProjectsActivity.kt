package com.example.company_application.view.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import com.example.company_application.view.report.ReportDetailActivity
import kotlinx.android.synthetic.main.activity_personal.*
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.activity_reports.*


class ProjectsActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        project_listView.adapter = adapter

        val sign = intent.getBooleanExtra("bool", false)
        if (sign){
            project_add.visibility = View.GONE
        }

        project_add.setOnClickListener{
            val intent = Intent(this, ProjectAddActivity::class.java)
            startActivityForResult(intent, 1)

        }

        project_listView.setOnItemClickListener { parent, view, position, id ->
            val element = view as TextView
            val data = element.text.toString()

            val intent = Intent(this, ProjectDetailActivity::class.java)
            intent.putExtra("projectData", data)
            startActivity(intent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        listItems.add("Игра")
        adapter.notifyDataSetChanged()
    }


}