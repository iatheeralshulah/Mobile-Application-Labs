package com.example.lab3

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme

@Preview(
    name = "Light",
    showBackground = true
)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Task7Preview() {
    Lab3Theme {
        StudentCard3(
            student = Student(
                name = "Atheer Alshulah",
                program = "Computer Science",
                gpa = "3.63",
                email = "2240004933@iau.edu.sa",
                city = "AlQatif"
            )
        )
    }
}

