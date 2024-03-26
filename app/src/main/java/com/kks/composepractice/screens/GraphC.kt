package com.kks.composepractice.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GraphC() {
    Text(
        text = "Graph C",
        fontSize = 30.sp
    )
}

@Composable
@Preview (showBackground = true)
fun GraphCPreview() {
    GraphC()
}