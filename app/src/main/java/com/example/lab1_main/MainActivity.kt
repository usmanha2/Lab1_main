package com.example.lab1_main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameGreeting = findViewById<EditText>(R.id.editName)
        val gButton = findViewById<Button>(R.id.buttonGreet)
        val gMe = findViewById<TextView>(R.id.greetMe)

        gButton.setOnClickListener{
            val name = nameGreeting.text.toString()
            if (name.isEmpty()){
                gMe.text = "Please slap me!"
            }else{
                gMe.text = "Hello, $name"
            }
        }
    }
}