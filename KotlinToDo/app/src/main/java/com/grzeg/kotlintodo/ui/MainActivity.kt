package com.grzeg.kotlintodo.ui

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.NavController

import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.grzeg.kotlintodo.R
import android.view.ViewGroup
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI(findViewById(R.id.nav_host_fragment))

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController

        setupActionBar(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        hideSoftKeyboard()
        return findNavController(this, R.id.nav_host_fragment).navigateUp()
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    private fun setupUI(view: View) {
        if (view !is EditText) {
            view.setOnTouchListener({ v, event ->
                hideSoftKeyboard()
                false
            })
        }

        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(innerView)
            }
        }
    }

    private fun hideSoftKeyboard() {
        val inputMethodManager: InputMethodManager  = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        if (this.currentFocus!= null) {
            inputMethodManager.hideSoftInputFromWindow(this.currentFocus.windowToken, 0)
        }
    }
}
