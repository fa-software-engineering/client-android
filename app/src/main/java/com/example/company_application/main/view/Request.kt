package com.example.company_application.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R

class Request : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        val userData = intent.getStringExtra("data")
    }
}