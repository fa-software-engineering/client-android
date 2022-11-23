package com.example.company_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_projects.*

class ReportsActivity : AppCompatActivity() {
    private var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter;

        listItems.add("Отчет 1")
        listItems.add("Отчет 2")

        adapter.notifyDataSetChanged()
    }
}