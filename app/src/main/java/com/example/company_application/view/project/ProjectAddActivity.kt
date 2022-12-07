package com.example.company_application.view.project

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_project_add.*


class ProjectAddActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_add)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        project_add_listView.adapter = adapter;

        add_skills.setOnClickListener {
            val text = skills_editText.text.toString()
            if (text.isEmpty()){
                Toast.makeText(this, "Поле скилов пустое", Toast.LENGTH_LONG).show()
            }else{
                listItems.add(text)
                val params = project_add_listView.layoutParams
                params.height += 90
                project_add_listView.layoutParams = params
                adapter.notifyDataSetChanged()
            }
        }

        save_project.setOnClickListener {
            onBackPressed()
            sendDataToDB("some")
        }
    }

    //TODO - Получение даннных с Api у бэка
    private fun getDataFromDB(){

    }
    //TODO - Отправка данных на Api у бэка
    private fun sendDataToDB(data : String){

    }



}