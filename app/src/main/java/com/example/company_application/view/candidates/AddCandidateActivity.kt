package com.example.company_application.view.candidates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_add_candidate.*

class AddCandidateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_candidate)

        add_activity_candidate_saveBtn.setOnClickListener{
            finish()
        }
    }
}