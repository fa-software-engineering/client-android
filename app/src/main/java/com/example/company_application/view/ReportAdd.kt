package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_report_add.*

class ReportAdd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_add)
        activity_report_add_buttonSaveReport.setOnClickListener{
            val code = activity_report_add_code_textField.text.toString()
            val name = activity_report_add_name_textField.text.toString()
            val description = activity_report_add_description_textField.text.toString()
            val data = arrayListOf(code, name, description)
            finish()
        }
    }
    //TODO - Получение даннных с Api у бэка
    private fun getDataFromDB(){

    }
    //TODO - Отправка данных на Api у бэка
    private fun sentDataToDB(data : String){

    }
}