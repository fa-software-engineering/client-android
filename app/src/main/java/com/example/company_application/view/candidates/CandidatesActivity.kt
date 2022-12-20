package com.example.company_application.view.candidates

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        array.add("Обломов Иван Александрович")
        arrayAdapter.notifyDataSetChanged()

        activity_candidates_addButton.setOnClickListener{
            val intent = Intent(this, AddCandidateActivity::class.java)
            startActivityForResult(intent, 1)
        }

        activity_candidates_listView.setOnItemClickListener{ parent, view, position, id ->
            val element = view as TextView
            val data = element.text.toString()
            Toast.makeText(this, "Данные о кандидате:\n $data", Toast.LENGTH_LONG).show()

            val intent = Intent(this, CandidateActivity::class.java)
            intent.putExtra("userData", data)
            startActivityForResult(intent, 2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            1 -> {
                array.add("Иванов Максим Викторович")
                arrayAdapter.notifyDataSetChanged()
            }
            2 -> {
                when(resultCode){
                    5 -> {
                        val name = data?.getStringExtra("data")
                    }
                    6 -> {
                        val name = data?.getStringExtra("dataToDelete")
                        array.remove(name)
                        arrayAdapter.notifyDataSetChanged()
                    }
                }

            }
        }
    }

    //TODO - Получение даннных с Api у бэка
    private fun getDataFromDB(){

    }
    //TODO - Отправка данных на Api у бэка
    private fun sentDataToDB(data : String){

    }

}