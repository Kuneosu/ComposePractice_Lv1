package com.kks.composepractice.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GraphB() {
    Box(modifier = Modifier.padding(top = 100.dp)){
        GraphBPieChart()
    }
}

@Composable
fun GraphBPieChart() {
    var bluePieSize by remember { mutableFloatStateOf(50f) }
    var redPieSize by remember { mutableFloatStateOf(50f) }
    val totalSize = bluePieSize + redPieSize

    Column {
        val deviceWidth = LocalConfiguration.current.screenWidthDp.dp
        BoxWithConstraints(
            modifier = Modifier
                .padding(20.dp)
                .height(deviceWidth - 20.dp)

        ) {
            val width = constraints.maxWidth.toFloat()
            Canvas(modifier = Modifier.size(width.dp)) {
                val bluePieAngle = 360 * (bluePieSize / totalSize)
                drawArc(
                    color = Color.Blue,
                    startAngle = 270f - bluePieAngle,
                    sweepAngle = bluePieAngle,
                    useCenter = true,
                    size = Size(width, width),
                )
            }

            Canvas(modifier = Modifier.size(width.dp)) {
                val redPieAngle = 360 * (redPieSize / totalSize)
                drawArc(
                    color = Color.Red,
                    startAngle = 270f,
                    sweepAngle = redPieAngle,
                    useCenter = true,
                    size = Size(width, width),
                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                if (bluePieSize < 100) {
                    bluePieSize += 10f
                    redPieSize -= 10f
                }
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Up Arrow",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Blue
                )
            }

            Spacer(modifier = Modifier.size(50.dp))

            IconButton(onClick = {
                if (redPieSize < 100) {
                    redPieSize += 10f
                    bluePieSize -= 10f
                }
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Up Arrow",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Red
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun GraphBPreview() {
    GraphB()
}