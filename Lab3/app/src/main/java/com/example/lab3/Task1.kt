package com.example.lab3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

@Composable
fun StudentCard1(
    student: Student,
    modifier: Modifier = Modifier
) {
}
