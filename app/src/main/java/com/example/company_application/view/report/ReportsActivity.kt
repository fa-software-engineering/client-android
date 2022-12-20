package com.example.company_application.view.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.company_application.R
import com.example.company_application.view.project.ProjectAddActivity
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.activity_reports.*

class ReportsActivity : AppCompatActivity() {
    private lateinit var listItems : ArrayList<String>
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        listItems = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        reports_listView.adapter = adapter


        val sign = intent.getBooleanExtra("bool", false)
        if (sign){
            activity_reports_buttonAdd.visibility = View.GONE
        }

        reports_listView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, ReportDetailActivity::class.java)
//            intent.putExtra("reportData", data)
            startActivity(intent)

        }
        activity_reports_buttonAdd.setOnClickListener{
            val intent = Intent(this, ReportAddActivity::class.java)
            startActivityForResult(intent, 1)
        }

        listItems.add("Отчет о создании интерфейса")
        listItems.add("Отчет о проектировании БД")
        adapter.notifyDataSetChanged()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        listItems.add("Отчет о разработке приложения")
        adapter.notifyDataSetChanged()
    }
}