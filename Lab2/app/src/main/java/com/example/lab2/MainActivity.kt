package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        task1()
        task2()
        task3()
        task4()
        task5()

        enableEdgeToEdge()

        setContent {
            Lab2Theme {
              TeamTaskTracker()
            }
        }
    }
}