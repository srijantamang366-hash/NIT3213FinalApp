package com.srijan.nit3213finalapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvProperty1 = findViewById<TextView>(R.id.tvProperty1)
        val tvProperty2 = findViewById<TextView>(R.id.tvProperty2)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)

        tvProperty1.text = intent.getStringExtra("property1") ?: ""
        tvProperty2.text = intent.getStringExtra("property2") ?: ""
        tvDescription.text = intent.getStringExtra("description") ?: ""
    }
}