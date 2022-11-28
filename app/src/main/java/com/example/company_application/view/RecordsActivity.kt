package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_projects.*

class RecordsActivity : AppCompatActivity() {
    private var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter;

        listItems.add("Отчет 1")
        listItems.add("Отчет 2")

        adapter.notifyDataSetChanged()
    }
}