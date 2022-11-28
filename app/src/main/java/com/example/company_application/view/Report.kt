package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R

class Report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        val data = intent.getStringExtra("reportData")
    }
}