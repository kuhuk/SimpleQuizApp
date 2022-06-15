package com.app.simplequizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.simplequizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var questions = listOf("What are the two official languages for Android development? \n\n A) Kotlin and Java \n\n B) Java and Python \n\n C) Kotlin and Python", "How do you define a function in Kotlin? \n\n A) void \n\n B) var \n\n C) function", "What is a variable used for? \n\n A) To contain data \n\n B) To insert a random value \n\n C) Don't know", "What does SDK stand for in Android SDK? \n\n A) Software Development Kit \n\n B) Software Development Kotlin \n\n C) Something Don't Know")
    private var rightAnswers = listOf(1, 2, 1, 1)
    private var questionNo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            showToast(1)
        }

        binding.button2.setOnClickListener {
            showToast(2)
        }

        binding.button3.setOnClickListener {
            showToast(3)
        }
    }

    private fun showToast(answer : Int) {
        if (answer == rightAnswers[questionNo]) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            updateQuestion()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateQuestion() {
        if (questionNo >= questions.size-1) {
            Toast.makeText(this, "Quiz Completed", Toast.LENGTH_SHORT).show()
        } else {
            questionNo++
            binding.textView.text = questions[questionNo]
        }
    }
}