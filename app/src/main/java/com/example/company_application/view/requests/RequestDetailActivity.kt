package com.example.company_application.view.requests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_request_detail.*

class RequestDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_detail)

        activity_request_buttonDone.setOnClickListener {
            setResult(6)
            finish()
        }
        activity_request_buttonAnswer.setOnClickListener {
            setResult(5)
            finish()
        }

    }
}