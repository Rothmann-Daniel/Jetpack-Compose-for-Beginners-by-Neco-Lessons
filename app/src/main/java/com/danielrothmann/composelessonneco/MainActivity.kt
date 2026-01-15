package com.danielrothmann.composelessonneco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .statusBarsPadding()
                ) {
                    showMenu()
                }
            }
        }
    }

    @Composable
    private fun showMenu() {
        val menu = createMenu()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
               // .background(Color.LightGray)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(menu) { _, itemShow ->
                    ItemFoodRow(
                        itemListFood = itemShow,
                        modifier = Modifier.background(Color.White)
                    )
                }
            }
        }
    }

    private fun createMenu(): List<ModelFood> {
        return listOf(
            ModelFood(R.drawable.im_combo, "Combo"),
            ModelFood(R.drawable.im_desert, "Desert"),
            ModelFood(R.drawable.im_french_fries, "French Fries"),
            ModelFood(R.drawable.im_pasta, "Pasta"),
            ModelFood(R.drawable.im_pizza, "Pizza"),
            ModelFood(R.drawable.im_salad, "Salat"),
            ModelFood(R.drawable.im_sushi, "Sushi")
        )
    }
}