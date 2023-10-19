package com.example.actividadpmul.actividad

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.actividadpmul.R

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text = "Hola $name!!"

    }
}