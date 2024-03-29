package com.kks.composepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun CalendarApp() {
    val calendarInstance = Calendar.getInstance()
    val time: MutableState<Calendar> = remember {
        mutableStateOf(calendarInstance)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarHeader(time)
        CalendarHeaderBtn(time)
        CalendarDayOfTheWeek()
        CalendarBody(time)
    }


}

@Composable
fun CalendarHeader(date: MutableState<Calendar>) {
    val nowDate = SimpleDateFormat("yyyy년 MM월", Locale.KOREA).format(date.value.time)
    Text(
        text = nowDate,
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
fun CalendarHeaderBtn(date: MutableState<Calendar>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                val newDate = Calendar.getInstance()
                newDate.time = date.value.time
                newDate.add(Calendar.MONTH, -1)
                date.value = newDate

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack")
        }

        Button(
            onClick = {
                val newDate = Calendar.getInstance()
                newDate.time = date.value.time
                newDate.add(Calendar.MONTH, 1)
                date.value = newDate
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "ArrowForward")
        }
    }

}

@Composable
fun CalendarDayOfTheWeek() {
    val datOfTheWeek = listOf("일", "월", "화", "수", "목", "금", "토")
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(
                start = 20.dp,
                top = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            datOfTheWeek.forEach {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                )
            }
        }
    }
}

@Composable
fun CalendarBody(date: MutableState<Calendar>) {

    val lastDay = date.value.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDay = date.value.get(Calendar.DAY_OF_WEEK) - 1
    val weeksCount = (firstDay + lastDay + 6) / 7

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(97, 97, 97, 26), shape = RoundedCornerShape(30.dp))
            .padding(
                start = 20.dp,
                top = 10.dp,
                bottom = 10.dp)
    ) {
        repeat(weeksCount) { week ->
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 5.dp),
            ) {
                repeat(7) { day ->
                    val dayNum = week * 7 + day - firstDay + 1
                    if (dayNum <= 0 || dayNum > lastDay) {
                        Text(
                            text = "",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f)
                        )
                    } else {
                        Text(
                            text = dayNum.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f)
                        )}
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CalendarPreview() {
    CalendarApp()
}