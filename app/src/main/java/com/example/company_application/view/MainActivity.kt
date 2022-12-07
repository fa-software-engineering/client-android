package com.example.company_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.company_application.R
import com.example.company_application.view.project.ProjectsActivity
import com.example.company_application.view.report.ReportsActivity
import com.example.company_application.view.staff.StaffActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

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
        this.menu = menu;
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.projects -> {
                startActivity(Intent(this, ProjectsActivity::class.java))
                true
            }
            R.id.reports -> {
                startActivity(Intent(this, ReportsActivity::class.java))
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
            //TODO: Вызов окна кандидатов
            R.id.candidates -> {
                startActivity(Intent(this, UserRequestsActivity::class.java))
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
                }
                '2' -> {
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.support).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.reports).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                }
                '3' -> {
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.request).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                }
                '4' -> {
                    menu.findItem(R.id.reports).isVisible = false
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.request).isVisible = false
                    menu.findItem(R.id.projects).isVisible = false
                }
                '5' -> {
                    menu.findItem(R.id.staff).isVisible = false
                    menu.findItem(R.id.candidates).isVisible = false
                    menu.findItem(R.id.request).isVisible = false
                }
            }
        }
    }
}