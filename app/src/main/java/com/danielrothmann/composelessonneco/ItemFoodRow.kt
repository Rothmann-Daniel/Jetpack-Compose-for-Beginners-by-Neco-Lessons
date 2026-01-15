package com.danielrothmann.composelessonneco

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ItemFoodRow(
    itemListFood: ModelFood,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier //  ИСПОЛЬЗУЕМ переданный modifier!
            .background(color = Color.White, RoundedCornerShape(8.dp)) // Скругленные углы  // Используем переданный modifier
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = itemListFood.imageId),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp) // выбираем фиксированный размер
                .clip(CircleShape) // выбираем форму круга
        )
        Text(
            text = itemListFood.title
        )
    }

}