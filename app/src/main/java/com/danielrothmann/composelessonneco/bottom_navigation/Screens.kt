package com.danielrothmann.composelessonneco.bottom_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Screens1() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen1",
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center

    )
}

@Composable
fun Screens2() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen2",
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center

    )
}

@Composable
fun Screens3() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen3",
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center

    )
}

@Composable
fun Screens4() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen4",
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center

    )
}