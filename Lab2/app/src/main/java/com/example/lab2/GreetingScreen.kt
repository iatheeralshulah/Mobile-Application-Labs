package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun GreetingCard() {

    var name by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }

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
                text = "Greeting Card",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 9 - TextField & state",
                color = AndroidGreen
            )
        }

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Your name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    submittedName = name.trim()
                },
                enabled = name.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AndroidGreen
                )
            ) {
                Text(
                    text = "Show greeting",
                    color = Navy
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (submittedName.isBlank()) {

                        Text(
                            text = "Type your name above\nto see the greeting."
                        )

                    } else {

                        Text(
                            text = "Marhaba, $submittedName!",
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Your name has ${submittedName.length} letters."
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "CSC 402 - Lab 2",
                            modifier = Modifier
                                .background(
                                    AndroidGreen,
                                    RoundedCornerShape(12.dp)
                                )
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                ),
                            color = Navy
                        )
                    }
                }
            }
        }
    }
}

