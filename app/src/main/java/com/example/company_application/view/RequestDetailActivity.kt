package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R

class RequestDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_detail)
        val userData = intent.getStringExtra("data")
    }
}