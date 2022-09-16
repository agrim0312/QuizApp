package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val finishBTN : Button = findViewById(R.id.finish_btn)
        var tv_username : TextView = findViewById(R.id.user_name)
        var tv_correct : TextView = findViewById(R.id.tv_correct)
        var correctAns = intent.getIntExtra(Constants.correctAns,0)
        var totalQuestion = intent.getIntExtra(Constants.totalQuestion,0)

        tv_username.text = intent.getStringExtra(Constants.user_name)
        tv_correct.text = "$correctAns/$totalQuestion are correct"

        finishBTN.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}