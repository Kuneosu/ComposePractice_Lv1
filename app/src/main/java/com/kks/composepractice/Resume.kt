package com.kks.composepractice

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Resume() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Android Developer Resume") })
        }
    ) {
        ResumeContent(paddingValues = it)
    }
}

@Composable
fun ResumeContent(paddingValues: PaddingValues) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = "profile",
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.White, CircleShape)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "자기소개",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "안녕하세요 안드로이드 개발자 김권수입니다.",
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "행복하고 유능한 개발자가 되고 싶습니다.",
                fontSize = 10.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Divider(color = Color.DarkGray, thickness = 1.dp)

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "전화번호 : 010-1234-5678",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

            Text(
                text = "이메일 : example@example.com",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.size(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"))
                    context.startActivity(intent)
                }) {
                Text(text = "전화 걸기")
            }

            Spacer(modifier = Modifier.size(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    val intent =
                        Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:example@example.com")
                        }
                    context.startActivity(intent)
                }) {
                Text(text = "이메일 보내기")
            }
        }
    }
}