package com.example.company_application.view.staff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_staff_detail.*

class StaffAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)


        save_personal_staff.setOnClickListener {
            onBackPressed()
            //сохрание в БД
        }

        delete_personal_staff.setOnClickListener {
            onBackPressed()
        }

    }
}