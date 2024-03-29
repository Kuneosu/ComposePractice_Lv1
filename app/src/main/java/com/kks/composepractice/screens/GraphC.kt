package com.kks.composepractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GraphC() {
    val numbers = remember { mutableStateListOf<Int>() }
    GraphCBarChart(numbers)
}

@Composable
fun GraphCBarChart(numbers: MutableList<Int>) {

    val maxValue = numbers.maxOrNull() ?: 0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            numbers.forEach { number ->
                Bar(number, maxValue, numbers.size)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            IconButton(onClick = {
                numbers.removeLastOrNull()
            }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remove Item"
                )
            }
            IconButton(onClick = {
                if (numbers.size < 15) {
                    val random = (1..10).random()
                    numbers.add(random)
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Item"
                )
            }
        }
    }

}

@Composable
fun Bar(number: Int, maxValue: Int, size: Int) {
    val height = 200 * number / maxValue
    val width = LocalConfiguration.current.screenWidthDp.dp / size
    // random color generator
    val red = (0..200).random()
    val green = (0..200).random()
    val blue = (0..200).random()
    Box(
        modifier = Modifier
            .height(height.dp)
            .width(width)
            .background(Color(red, green, blue)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = number.toString(),
            color = Color.White,
            modifier = Modifier.padding(bottom = 5.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GraphCPreview() {
    GraphC()
}