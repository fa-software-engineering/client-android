package com.example.company_application.view.staff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.company_application.R
import com.example.company_application.view.project.ProjectDetailActivity
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.activity_staff.*

class StaffActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        staff_listView.adapter = adapter;

        listItems.add("Сотрудник 1")
        listItems.add("Сотрудник 2")
        adapter.notifyDataSetChanged()

        staff_listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, StaffDetailActivity::class.java)
            startActivity(intent)

        }

        search_staff.setOnClickListener {
            searchBySkills(skills_edit_text.text.toString())
            searchByDate(day_edit_text.text.toString().toInt())
        }

        add_staff.setOnClickListener {
            val intent = Intent(this, StaffAddActivity::class.java)
            startActivity(intent)
        }

    }

    private fun searchBySkills(skills: String){
        //запрос в БД, сравнение
    }

    private fun searchByDate(days: Int){
        //запрос в БД, сравнение
    }



}