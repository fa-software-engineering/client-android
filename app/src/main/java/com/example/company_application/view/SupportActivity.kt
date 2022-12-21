package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_support.*


class SupportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        button5.setOnClickListener {
            finish()
        }
    }
}