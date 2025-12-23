package com.danielrothmann.composelessonneco

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())//Скролл с запоминанием позиции
            ) {
                listItem("Daniel Rothmann", "Android Developer")
                listItem("Viktoria Rothmann", "Java Developer")
                listItem("John Doe", "iOS Developer")
                listItem("Jane Doe", "Flutter Developer")
                listItem("John Doe", "Kotlin Developer")
                listItem("John Doe","RxJava")
                listItem("John Doe","C++")
                listItem("John Doe","React Native")
                listItem("John Doe","C#")
                listItem("John Doe","Python")
                listItem("John Doe","Node.js")
                listItem("John Doe","C#")
                listItem("John Doe","Python")
                listItem("John Doe","Node.js")
            }

        }
    }
}

@Composable
private fun listItem(name: String, profile: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.offset(5.dp,5.dp) // Отступ он основного элемента
            .padding(4.dp)
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress { change, dragAmount ->
                    Log.d("MyLog", "LongPress: $change, $dragAmount")
                }
            }

           /* .clickable {
                // Действия при клике
                Log.d("MyLog", "Click")
            }*/
            .shadow(5.dp), // Форма тени по умолчанию возьмётся из Card
        /* Альтернативно
           .shadow(
              elevation = 5.dp,
              shape = RoundedCornerShape(16.dp) // Форма для тени */
        shape = RoundedCornerShape(16.dp), // Форма для карточки
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Фон всей карточки
        )
    ) {
        //Box по умолчанию занимает только столько места, сколько нужно его дочерним элементам (wrap content)
        Box(
            modifier = Modifier.fillMaxWidth(),  // Занимает всю ширину Card
            // .background(color = Color.Green),  // бэк для контейнера
            // contentAlignment = Alignment.Center //позволяет перемещать элементы внутри Box (1 элемент общий - Row)
        ) {
            Row(
                // modifier = Modifier.background(color = Color.Red), // бэк для контейнера
                verticalAlignment = Alignment.CenterVertically //все элементы в Row друг за другом можно сразу выравнить все
            ) {
                Image(
                    painter = painterResource(R.drawable.signatire),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color = Color.LightGray)
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                    //.background(color = Color.Cyan) // бэк для контейнера
                ) {
                    Text(
                        text = name
                    )
                    Text(
                        text = profile
                    )
                }

            }

        }

    }

}

