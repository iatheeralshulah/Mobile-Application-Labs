package com.example.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Chain A
@Composable
fun ChainA(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}

// Chain B
@Composable
fun ChainB(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .padding(24.dp)
            .background(Color(0xFF3DDC84))
    )
}

// Chain C
@Composable
fun ChainC(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}

// Preview for the three chains
@Preview(showBackground = true)
@Composable
fun Task4Preview() {
    Column {
        ChainA()
        ChainB()
        ChainC()
    }
}

// Tap-target test
@Composable
fun TapTargetExample() {
    Column(
        modifier = Modifier.padding(top = 80.dp)
    ) {
        Text(
            text = "Clickable then Padding",
            modifier = Modifier
                .clickable { }
                .padding(16.dp)
        )

        Text(
            text = "Padding then Clickable",
            modifier = Modifier
                .padding(16.dp)
                .clickable { }
        )
    }
}