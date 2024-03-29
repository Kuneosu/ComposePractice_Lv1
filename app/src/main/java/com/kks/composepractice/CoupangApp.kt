package com.kks.composepractice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoupangApp() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        TopLogoArea()
        SearchBarArea()
        TopBanner()
        CategoryList()
        CenterBannerArea()
    }
}

@Composable
fun TopLogoArea() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(text = "c", fontSize = 50.sp, color = Color(82, 17, 16))
            Text(text = "o", fontSize = 50.sp, color = Color(82, 17, 16))
            Text(text = "u", fontSize = 50.sp, color = Color(82, 17, 16))
            Text(text = "p", fontSize = 50.sp, color = Color(215, 50, 38))
            Text(text = "a", fontSize = 50.sp, color = Color(233, 153, 35))
            Text(text = "n", fontSize = 50.sp, color = Color(145, 186, 62))
            Text(text = "g", fontSize = 50.sp, color = Color(79, 163, 217))
        }

        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarArea() {
    val inputText = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .border(1.dp, Color(213, 219, 225), shape = RoundedCornerShape(10.dp))
    ) {
        TextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            placeholder = {
                Text(text = "검색어를 입력해주세요")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopBanner() {
    val textList = listOf("1", "2", "3", "4", "5")
    val pagerState = rememberPagerState() {
        textList.size
    }
    val colorList = listOf(
        Color(255, 0, 0),
        Color(0, 255, 0),
        Color(0, 0, 255),
        Color(255, 255, 0),
        Color(255, 0, 255)
    )

    Box(
        modifier = Modifier.padding(20.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    color = colorList[pagerState.currentPage],
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp),

            ) { page ->
            Text(
                text = textList[page],
                fontSize = 40.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )

        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }


    }
}

@Composable
fun CategoryList() {
    val categoryList = listOf("전체", "신상품", "베스트", "할인", "쿠팡로켓", "전체", "신상품", "베스트", "할인", "쿠팡로켓")
    val categoryIconList = listOf(
        Icons.Default.Menu,
        Icons.Default.Notifications,
        Icons.Default.ThumbUp,
        Icons.Default.Favorite,
        Icons.Default.ShoppingCart,
        Icons.Default.Menu,
        Icons.Default.Notifications,
        Icons.Default.ThumbUp,
        Icons.Default.Favorite,
        Icons.Default.ShoppingCart
    )
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .padding(10.dp)
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        categoryList.forEachIndexed { index, category ->
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = categoryIconList[index],
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = category)

                Spacer(modifier = Modifier.size(20.dp))

                Icon(
                    imageVector = categoryIconList[index],
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = category)
            }
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun CenterBannerArea() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(20.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "배너영역", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
@Preview(showBackground = true)
fun CoupangPreview() {
    CoupangApp()
}