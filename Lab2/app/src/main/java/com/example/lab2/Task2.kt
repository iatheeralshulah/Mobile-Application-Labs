package com.example.lab2

fun greetStudent(
    name: String,
    course: String = "CSC 402"
): String {
    return "Welcome to $course, $name!"
}

fun finalMark(
    quizzes: Double,
    project: Double,
    finalExam: Double
): Double =
    quizzes * 0.10 +
            project * 0.70 +
            finalExam * 0.20

fun printBanner(
    title: String,
    width: Int = 40
) {
    val line = "-".repeat(width)
    println(line)
    println(title)
    println(line)
}

fun task2() {

    printBanner("CSC 402 Lab 2")

    println(greetStudent("Sara"))
    println(greetStudent("Sara", "CSC 311"))

    val result1 = finalMark(80.0, 90.0, 85.0)

    val result2 = finalMark(
        finalExam = 85.0,
        quizzes = 80.0,
        project = 90.0
    )

    println("Positional result: $result1")
    println("Named result: $result2")
}