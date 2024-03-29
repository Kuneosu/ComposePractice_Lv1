package com.kks.composepractice

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

// 포켓볼 주소 : https://cdn.pixabay.com/photo/2016/07/23/13/18/pokemon-1536849_1280.png
// 포켓몬 주소 : https://cdn.pixabay.com/photo/2021/12/26/17/31/pokemon-6895600_1280.png

@Composable
fun PocketCard() {
    var cardFront by remember {
        mutableStateOf(true)
    }

    val animationDegree by animateFloatAsState(
        targetValue = if (cardFront) 0f else 180f,
        animationSpec = tween(500), label = ""
    )

    Log.d("PocketCard", "PocketCard: cardFront = $cardFront")
    Log.d("PocketCard", "PocketCard: animationDegree = $animationDegree")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 20.dp)
            .clickable {
                cardFront = !cardFront
                Log.d("PocketCard", "PocketCard: cardFront = $cardFront")
                Log.d("PocketCard", "PocketCard: animationDegree = $animationDegree")
            }
            .graphicsLayer {
                rotationY = animationDegree
            }

    ) {
        if (animationDegree < 90) {
            PocketCardFront()
        } else {
            PocketCardBack()
        }
    }
}

@Composable
fun PocketCardFront() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD700), shape = RoundedCornerShape(30.dp))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.Black, shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                model = "https://cdn.pixabay.com/photo/2016/07/23/13/18/pokemon-1536849_1280.png",
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
    }

}

@Composable
fun PocketCardBack() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD700), shape = RoundedCornerShape(30.dp))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color(0xFFF44336), shape = RoundedCornerShape(30.dp))
                .graphicsLayer {
                    rotationY = 180f
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    model = "https://cdn.pixabay.com/photo/2021/12/26/17/31/pokemon-6895600_1280.png",
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "파이리",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }
    }
}


@Composable
@Preview
fun PreviewPocketCard() {
    PocketCard()
}