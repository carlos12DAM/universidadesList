package com.example.actividadpmul.actividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.actividadpmul.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnClick = findViewById<Button>(R.id.boton1)
        val etname = findViewById<EditText>(R.id.Et1)


        btnClick.setOnClickListener {
            val name = etname.text.toString()

            if(name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME",name)
                startActivity(intent)

            }
        }

    }
}