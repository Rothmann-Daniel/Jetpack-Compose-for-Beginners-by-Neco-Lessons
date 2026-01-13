package com.danielrothmann.composelessonneco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                contentAlignment = Alignment.Center
            ) {
                circleItem()
            }

        }
    }
}

@Composable
private fun circleItem() {
    var counter = remember {
        mutableStateOf(0) // запоминаем состояние
    }
    var color = remember {
        mutableStateOf(Color.Blue) // запоминаем состояние
    }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                // Действия при клике
                counter.value++
            }

    ) {
        Text(
            text = counter.value.toString()
        )
       if (counter.value < 10) {
            color.value = Color.Blue
        }
        else{
           color.value = Color.Red
       }
    }


}

