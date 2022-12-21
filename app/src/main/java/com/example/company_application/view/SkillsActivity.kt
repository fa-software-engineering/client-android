package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_project_add.*
import kotlinx.android.synthetic.main.activity_project_add.add_skills
import kotlinx.android.synthetic.main.activity_skills.*

class SkillsActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        skills_add_listView.adapter = adapter

        create_skills.setOnClickListener {
            val text = create_skills_edit_text.text.toString()
            if (text.isEmpty()){
                Toast.makeText(this, "Введите название", Toast.LENGTH_LONG).show()
            }else{
                listItems.add(text)
                val params = skills_add_listView.layoutParams
                params.height += 90
                skills_add_listView.layoutParams = params
                adapter.notifyDataSetChanged()
            }
        }
    }
}