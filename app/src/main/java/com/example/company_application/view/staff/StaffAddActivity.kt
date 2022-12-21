package com.example.company_application.view.staff

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_staff_detail.*


class StaffAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)



        save_personal_staff.setOnClickListener {
            intent.putExtra("name", fio_edit_text.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

        delete_personal_staff.setOnClickListener {
            onBackPressed()
        }

    }


}