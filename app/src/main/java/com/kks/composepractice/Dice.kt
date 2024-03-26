package com.kks.composepractice

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dice() {
    var diceNumber by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier =
            Modifier
                .size(300.dp)
                .border(3.dp, color = Color.Black)
                .background(Color.White)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            when (diceNumber) {
                1 -> DiceCircle1()
                2 -> DiceCircle2()
                3 -> DiceCircle3()
                4 -> DiceCircle4()
                5 -> DiceCircle5()
                6 -> DiceCircle6()
            }
        }

        Button(
            onClick = {
                diceNumber = (1..6).random()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            )
        ) {
            Text(
                text = "주사위 굴리기",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }


        Text(
            text = "주사위 숫자: $diceNumber",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun DiceCircle1() {
    Box(
        modifier = Modifier
            .size(50.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = Color.Red, radius = 50f)
        }
    }
}

@Composable
fun DiceCircle2() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        DiceCircle1()
        Spacer(modifier = Modifier.size(50.dp))
        DiceCircle1()
    }
}

@Composable
fun DiceCircle3() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            DiceCircle1()
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DiceCircle1()
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            DiceCircle1()
        }
    }
}

@Composable
fun DiceCircle4() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DiceCircle1()
            DiceCircle1()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DiceCircle1()
            DiceCircle1()
        }


    }
}

@Composable
fun DiceCircle5() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DiceCircle1()
            DiceCircle1()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DiceCircle1()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DiceCircle1()
            DiceCircle1()
        }
    }
}

@Composable
fun DiceCircle6() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        DiceCircle2()
        DiceCircle2()
        DiceCircle2()
    }
}