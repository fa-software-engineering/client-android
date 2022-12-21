package com.example.company_application.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.company_application.R
import com.example.company_application.view.candidates.CandidatesActivity
import com.example.company_application.view.project.ProjectsActivity
import com.example.company_application.view.report.ReportsActivity
import com.example.company_application.view.requests.UserRequestsActivity
import com.example.company_application.view.staff.StaffActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_personal.*


class MainActivity : AppCompatActivity() {
    private var login: String? = null
    private lateinit var menu: Menu

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        openRegistrationScreen()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        this.menu = menu
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.projects -> {
                val intent = Intent(this, ProjectsActivity::class.java)

                if (fio_edit.text.toString() == "Шарков Андрей Владимирович") {
                    intent.putExtra("bool", true)
                } else {
                    intent.putExtra("bool", false)
                }
                startActivity(intent)
                true
            }
            R.id.reports -> {
                val intent = Intent(this, ReportsActivity::class.java)

                if (fio_edit.text.toString() == "Шарков Андрей Владимирович") {
                    intent.putExtra("bool", true)
                } else {
                    intent.putExtra("bool", false)
                }
                startActivity(intent)
                true
            }
            R.id.staff -> {
                startActivity(Intent(this, StaffActivity::class.java))
                true
            }
            R.id.request -> {
                startActivity(Intent(this, UserRequestsActivity::class.java))
                true
            }
            R.id.support -> {
                startActivity(Intent(this, SupportActivity::class.java))
                true
            }
            R.id.candidates -> {
                startActivity(Intent(this, CandidatesActivity::class.java))
                true
            }
            R.id.skills -> {
                startActivity(Intent(this, SkillsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openRegistrationScreen() {

        // Choose authentication providers
        val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())

        // Create and launch sign-in intent
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            login = user?.email.toString()
            //проверка, какой пользователь входит
            when (login!![0]) {
                '1' -> {
                    menu.findItem(R.id.request).isVisible = false
                    menu.findItem(R.id.candidates).isVisible = false
                    fio_edit.text = "Лавров Никита Михайлович"
                    depart_edit.text = "Отдел разработки"
                    pos_edit.text = "Руководитель отдела"
                    grade_edit.text = "Руководитель"
                    skills_edit.text = "Менеджмент, моделирование процессов разработки"
                }
                '2' -> {
                    menu.findItem(R.id.skills).isVisible = false
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.support).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.reports).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                    fio_edit.text = "Лазарев Андрей Абрамович"
                    depart_edit.text = "Отдел аналитики"
                    pos_edit.text = "Главный аналитик"
                    grade_edit.text = "Руководитель отдела"
                    skills_edit.text = "Сбор и анализ требований заказчиков"


                }
                '3' -> {
                    menu.findItem(R.id.skills).isVisible = false
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.reports).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                    fio_edit.text = "Маликов Артем Игоревич"
                    depart_edit.text = "Отдел службы поддержки"
                    pos_edit.text = "Сотрудник службы поддержки"
                    grade_edit.text = "Младший сотрудник"
                    skills_edit.text = "Четкая и грамотно поставленная речь"

                }
                '4' -> {
                    menu.findItem(R.id.skills).isVisible = false
                    menu.findItem(R.id.reports).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.request).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                    fio_edit.text = "Абрамов Евгений Михайлович"
                    depart_edit.text = "HR отдел"
                    pos_edit.text = "HR менеджер"
                    grade_edit.text = "Менеджер отдела"
                    skills_edit.text = "Отслеживание ситуации на рынке труда в стране"

                }
                '5' -> {
                    menu.findItem(R.id.skills).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.request).isVisible = false

                    fio_edit.text = "Шарков Андрей Владимирович"
                    depart_edit.text = "Отдел разработки"
                    pos_edit.text = "Младший Android разработчик"
                    grade_edit.text = "Разработчик"
                    skills_edit.text = "Kotlin, XML"
                }
            }
        }
    }
}