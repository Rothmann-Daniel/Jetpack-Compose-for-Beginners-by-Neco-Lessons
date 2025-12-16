package com.danielrothmann.composelessonneco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                // Первая часть - Row
                Row(
                    modifier = Modifier
                        .weight(1f)  // Занимает половину экрана
                        .fillMaxWidth()
                        .background(color = Color.Yellow),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    newText()
                    Text(text = "RowDescription")
                    Text(text = "Row_SOME_TEXT")
                }

                // Вторая часть - Column
                Column(
                    modifier = Modifier
                        .weight(1f)  // Занимает вторую половину экрана
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "ColumnTitle")
                    Text(text = "ColumnDescription")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun newText() {
        Text(text = "RowTitle")
    }
}