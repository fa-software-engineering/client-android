package com.example.company_application.view.candidates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_candidate.*

class CandidateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)

        val data = intent.getStringExtra("userData")

        activity_candidate_add_FIO_textField.setText(data)

        activity_candidate_saveBtn.setOnClickListener{
            setResult(5,intent.putExtra("data", data))
            finish()
        }

        activity_candidate_deleteBtn.setOnClickListener{
            setResult(6, intent.putExtra("dataToDelete", data))
            finish()
        }

    }
}