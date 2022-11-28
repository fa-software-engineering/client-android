package com.example.company_application.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_reports.*

class ReportsActivity : AppCompatActivity() {
    private lateinit var array : ArrayList<String>
    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        array = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        activity_reports_listView.adapter = arrayAdapter

        activity_reports_listView.setOnItemClickListener { parent, view, position, id ->
            val element = view as TextView
            val data = element.text.toString()
            Toast.makeText(this, "Данные выбранного отчета: $data", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ReportDetailActivity::class.java)
            intent.putExtra("reportData", data)
            startActivity(intent)

        }
        activity_reports_buttonAdd.setOnClickListener{
            val intent = Intent(this, ReportAddActivity::class.java)
            startActivity(intent)
        }
    }

    //TODO - Получение даннных с Api у бэка
    private fun getDataFromDB(){

    }
    //TODO - Отправка данных на Api у бэка
    private fun sentDataToDB(data : String){

    }
}