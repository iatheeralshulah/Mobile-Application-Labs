package com.example.lab3


import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab3.ui.theme.Lab3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(
    modifier: Modifier = Modifier
) {

    val students = listOf(
        Student(
            name = "Atheer Alshulah",
            program = "Computer Science",
            gpa = "3.63",
            email = "2240004933@iau.edu.sa",
            city = "AlQatif"
        ),
        Student(
            name = "Sara Ahmed",
            program = "Computer Science",
            gpa = "4.20",
            email = "sara@iau.edu.sa",
            city = "Dammam"
        ),
        Student(
            name = "Lama Ali",
            program = "Information Systems",
            gpa = "3.90",
            email = "lama@iau.edu.sa",
            city = "Khobar"
        ),
        Student(
            name = "Noura Khalid",
            program = "Computer Science",
            gpa = "4.55",
            email = "noura@iau.edu.sa",
            city = "Dhahran"
        ),
        Student(
            name = "Reem Mohammed",
            program = "Cyber Security",
            gpa = "4.10",
            email = "reem@iau.edu.sa",
            city = "Dammam"
        )
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = {
                    Text("Students")
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 16.dp,
                bottom = innerPadding.calculateBottomPadding() + 16.dp
            ),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Student List",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "${students.size} Students",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            items(students) { student ->
                StudentCard3(
                    student = student
                )
            }
        }
    }
}

@Preview(
    name = "Task 10 Light",
    showBackground = true
)
@Preview(
    name = "Task 10 Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Task10Preview() {
    Lab3Theme {
        StudentListScreen()
    }
}
