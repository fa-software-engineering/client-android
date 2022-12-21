package com.example.company_application.view.staff

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.activity_staff.*


class StaffActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        staff_listView.adapter = adapter

        listItems.add("Иванов Андрей Михайлович")
        listItems.add("Волков Владимир Дмитриевич")

        adapter.notifyDataSetChanged()

        staff_listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, StaffDetailActivity::class.java)
            startActivity(intent)

        }

        search_staff.setOnClickListener {
            listItems.clear()
            listItems.add("Гроздев Виктор Олегович")
            adapter.notifyDataSetChanged()
        }

        add_staff.setOnClickListener {
            val intent = Intent(this, StaffAddActivity::class.java)
            startActivityForResult(intent ,1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        listItems.add(data?.getStringExtra("name").toString())
        adapter.notifyDataSetChanged()
    }


    private fun searchBySkills(skills: String){
        //запрос в БД, сравнение
    }

    private fun searchByDate(days: Int){
        //запрос в БД, сравнение
    }



}