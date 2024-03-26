package com.kks.composepractice.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GraphB() {
    Text(
        text = "Graph B",
        fontSize = 30.sp
    )
}

@Composable
@Preview (showBackground = true)
fun GraphBPreview() {
    GraphB()
}