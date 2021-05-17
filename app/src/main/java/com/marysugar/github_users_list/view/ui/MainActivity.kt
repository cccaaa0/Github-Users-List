package com.marysugar.github_users_list.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marysugar.github_users_list.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ListFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }
}