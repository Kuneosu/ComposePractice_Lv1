package com.kks.composepractice.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GraphA() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GraphAGauge()
    }
}

@Composable
fun GraphAGauge() {
    var percent by remember { mutableFloatStateOf(0.0f) }
    val maxPercent = 100.0f
    val colorPercent = (percent / maxPercent) * 360
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .aspectRatio(1f)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawArc(
                    color = Color.LightGray,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(35f)
                )

                drawArc(
                    color = Color.Blue,
                    startAngle = -90f,
                    sweepAngle = colorPercent,
                    useCenter = false,
                    style = Stroke(35f)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${((percent / maxPercent) * 100).toInt()} %",
                    fontSize = 35.sp
                )
                Text(
                    text = "$percent / $maxPercent",
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                if (percent > 0) percent -= 10.0f
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.size(50.dp))

            IconButton(onClick = {
                if (percent < maxPercent) percent += 10.0f
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Up Arrow",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun GraphAPreview() {
    GraphA()
}