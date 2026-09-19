package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun AttendanceCounter() {

    var count by remember { mutableStateOf(0) }

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
                text = "Attendance Counter",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 8 - remember & state",
                color = AndroidGreen
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "STUDENTS PRESENT",
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(110.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$count",
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Button(
                    onClick = {
                        if (count > 0) count--
                    },
                    enabled = count > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    )
                ) {
                    Text("-")
                }

                Button(
                    onClick = {
                        count++
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AndroidGreen
                    )
                ) {
                    Text("+", color = Navy)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = { count = 0 },
                enabled = count > 0
            ) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = if (count == 0) {
                    "Tap + to check a student in."
                } else {
                    "$count of 30 students checked in."
                }
            )
        }
    }
}

