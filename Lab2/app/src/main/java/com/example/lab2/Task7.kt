package com.example.lab2


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.AndroidGreen
import com.example.lab2.ui.theme.Navy
import com.example.lab2.ui.theme.ScreenBackground

@Composable
fun StudentIdScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(16.dp)
    ) {

        Text(
            text = "Student ID",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Navy
        )

        Text(
            text = "Task 7 - Row & Column",
            color = AndroidGreen
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Navy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AA",
                        color = AndroidGreen,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {

                    Text(
                        text = "Atheer Alshulah",
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = "Computer Science")

                    Text(
                        text = "2240004933",
                        fontFamily = FontFamily.Monospace
                    )

                    Row {
                        Text(
                            text = "Level 4",
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(AndroidGreen)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "CSHJ",
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.LightGray)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("4.42", "GPA")
                StatItem("78", "Credits")
                StatItem("Active", "Status")
            }
        }
    }
}

@Composable
fun StatItem(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}