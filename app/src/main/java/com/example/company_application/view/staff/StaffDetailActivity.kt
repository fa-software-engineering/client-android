package com.example.company_application.view.staff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_staff_detail.*

class StaffDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)

        //заполение полей из БД
        fio_edit_text.setText("")
        depart_edit_text.setText("")
        pos_edit_text.setText("")
        grade_edit_text.setText("")
        skills_edit_text.setText("")

        save_personal_staff.setOnClickListener {
            onBackPressed()
            //сохрание в БД
        }

        delete_personal_staff.setOnClickListener {
            //удаление с БД
            onBackPressed()
        }
    }
}