package com.kks.composepractice.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        GraphAGauge(percent = 70f, maxPercent = 100f)
    }
}

@Composable
fun GraphAGauge(percent: Float, maxPercent: Float) {
    val colorPercent = (percent / maxPercent) * 360

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
}

@Composable
@Preview(showBackground = true)
fun GraphAPreview() {
    GraphA()
}