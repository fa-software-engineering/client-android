package com.example.company_application.view.report

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_report_add.*

class ReportAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_add)
        activity_report_add_buttonSaveReport.setOnClickListener {
            finish()
        }
    }
}