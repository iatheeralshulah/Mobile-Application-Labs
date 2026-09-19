package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TeamTaskTracker() {

    val tasks = remember {
        mutableStateListOf(
            TeamTask(1, "Create GitHub repository", "Reem", true),
            TeamTask(2, "Write project proposal", "Omar", true),
            TeamTask(3, "Design the login screen", "Noura", false),
            TeamTask(4, "Set up Android Studio", "Yousef", false)
        )
    }

    val done = tasks.count { it.isDone }
    val open = tasks.count { !it.isDone }
    val total = tasks.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {
            Text(
                text = "Team Task Tracker",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 11 - Challenge",
                color = AndroidGreen
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SummaryItem(done.toString(), "Done")
            SummaryItem(open.toString(), "Open")
            SummaryItem(total.toString(), "Total")
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(tasks, key = { it.id }) { task ->

                TaskRow(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst { it.id == task.id }

                        if (index != -1) {
                            tasks[index] = task.copy(
                                isDone = !task.isDone
                            )
                        }
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId =
                    (tasks.maxOfOrNull { it.id } ?: 0) + 1

                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Atheer Alshulah"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen
            )
        ) {
            Text(
                text = "+ Add task",
                color = Navy
            )
        }
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                }
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    color = if (task.isDone) Color.Gray else Color.Black,
                    textDecoration =
                        if (task.isDone)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None
                )

                Text(
                    text = task.owner,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun SummaryItem(
    value: String,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = AndroidGreen
        )

        Text(
            text = label,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamTaskTrackerPreview() {
    Lab2Theme {
        TeamTaskTracker()
    }
}