package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_candidate.*

class CandidateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)

        val data = intent.getStringExtra("userData")
        // TODO потом заполнить филды data

        activity_candidate_saveBtn.setOnClickListener{
            val fio = activity_candidate_add_FIO_textField.text.toString()
            val role = activity_candidate_add_role_textField.text.toString()
            val position = activity_candidate_add_position_textField.text.toString()
            val skills = activity_candidate_add_skills_textField.text.toString()
            val grade = activity_candidate_add_grade_textField.text.toString()

            val data = arrayListOf(fio, role, position, skills, grade)

            finish()
        }

        activity_candidate_deleteBtn.setOnClickListener{
            // TODO удаление кандидата
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