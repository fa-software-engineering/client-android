package com.example.company_application.view.requests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_user_requests.*

class UserRequestsActivity : AppCompatActivity() {
    private lateinit var array : ArrayList<String>
    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_requests)
        array = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        activity_user_requests_listView.adapter = arrayAdapter
        array.add("Проблема с соединением")

        activity_user_requests_listView.setOnItemClickListener{
            parent, clickedView, position, id ->
            val item = clickedView as TextView
            val data : String = item.text.toString()
            Toast.makeText(this, "Вы выбрали обращение: $data", Toast.LENGTH_LONG).show()

            val intent = Intent(this, RequestDetailActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            5 ->{
                Toast.makeText(this, "Вы ответили на обращение пользователя", Toast.LENGTH_LONG).show()
            }
            6 -> {
                Toast.makeText(this, "Обращение пользователя решено", Toast.LENGTH_LONG).show()
                array.remove("Проблема с соединением")
                arrayAdapter.notifyDataSetChanged()
            }
        }
    }
}