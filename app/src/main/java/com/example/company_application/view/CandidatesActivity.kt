package com.example.company_application.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.example.company_application.R
import kotlinx.android.synthetic.main.activity_candidate.*
import kotlinx.android.synthetic.main.activity_candidates.*

class CandidatesActivity : AppCompatActivity() {
    private lateinit var array : ArrayList<String>
    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidates)

        array = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        activity_candidates_listView.adapter = arrayAdapter

        activity_candidates_addButton.setOnClickListener{
            // зачем иметь тогда при добавлении кнопку удалить - бред! - поэтому если нажимаем на кнопку добавить кандидата - кнопка удалить становится невидимой
            activity_candidate_deleteBtn.visibility = View.INVISIBLE
            val intent = Intent(this, CandidateActivity::class.java)
            startActivity(intent)
        }

        activity_candidates_listView.setOnItemClickListener{ parent, view, position, id ->
            val element = view as TextView
            val data = element.text.toString()
            Toast.makeText(this, "Данные о кандидате:\n $data", Toast.LENGTH_LONG).show()
            // изменим еще название кнопки для того, чтобы изменить данные (вместо добавить будет изменить)
            activity_candidate_saveBtn.text = "Изменить"
            val intent = Intent(this, CandidateActivity::class.java)
            // Добавляем данные (чтобы заполнить текстФилдики)
            intent.putExtra("userData", "data")
            startActivity(intent)
        }

    }
    //TODO - Получение даннных с Api у бэка
    private fun getDataFromDB(){

    }
    //TODO - Отправка данных на Api у бэка
    private fun sentDataToDB(data : String){

    }
}