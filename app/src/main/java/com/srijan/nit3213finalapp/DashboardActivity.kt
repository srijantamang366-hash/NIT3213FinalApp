package com.srijan.nit3213finalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val keypass = intent.getStringExtra("keypass") ?: ""
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getDashboard(keypass)

        viewModel.entities.observe(this) { result ->
            result.onSuccess { entities ->
                val adapter = EntityAdapter(entities) { entity ->
                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putExtra("property1", entity.property1)
                    intent.putExtra("property2", entity.property2)
                    intent.putExtra("description", entity.description)
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        }
    }
}