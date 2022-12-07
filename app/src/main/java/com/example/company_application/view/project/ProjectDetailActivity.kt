package com.example.company_application.view.project

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_project_detail.*
import kotlinx.android.synthetic.main.activity_project_detail.view.skills_column
import kotlinx.android.synthetic.main.activity_project_detail.view.task_column
import kotlinx.android.synthetic.main.activity_staff_detail.*
import kotlinx.android.synthetic.main.table_row.view.*


class ProjectDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_detail)

        val row: TableRow = LayoutInflater.from(this)
            .inflate(R.layout.table_row, null) as TableRow
        row.task_column.text = "gkofk"
        row.skills_column.text = "gkofk"
        row.checkbox.isChecked = true
        task_table.addView(row)

        save_project_detail.setOnClickListener {
            onBackPressed()
        }


    }

}