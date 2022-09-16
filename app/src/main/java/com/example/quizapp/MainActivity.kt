package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var strtBtn : Button = findViewById(R.id.na_btn)
        val nameInput : EditText = findViewById(R.id.etName)
        val emailInput : EditText = findViewById(R.id.etEmail)

        strtBtn.setOnClickListener {
            if (nameInput.text.isNotEmpty() && emailInput.text.isNotEmpty()){
                val intent = Intent(this,quizQuestions::class.java)
                intent.putExtra(Constants.user_name,nameInput.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "please fill the information", Toast.LENGTH_SHORT).show()
            }
        }
    }
}