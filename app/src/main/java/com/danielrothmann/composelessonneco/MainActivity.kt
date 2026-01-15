package com.danielrothmann.composelessonneco

import ItemFood
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielrothmann.composelessonneco.ui.theme.TsstColor1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            showMenu()
        }
    }

    @Preview
    @Composable
    private fun showMenu() {
        val menu = createMenu()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(TsstColor1)  // Тестовый фон для LazyRow
                .padding(horizontal = 8.dp, vertical = 8.dp),  // Отступы по бокам и сверху/снизу
            verticalArrangement = Arrangement.spacedBy(6.dp), //  Отступы между элементами
        ) {
            itemsIndexed(menu) { index, itemShow ->
                ItemFood(
                    itemListFood = itemShow
                )
            }
        }
    }
}


// Функция возвращает список, а не один элемент
private fun createMenu(): List<ModelFood> {
    return listOf(
        ModelFood(R.drawable.im_combo, "Combo", "SomeText"),
        ModelFood(R.drawable.im_desert, "Desert", "SomeTextSomeTextSomeTextSomeText" +
                "SomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeText" +
                "SomeTextSomeTextSomeTextSome" +
                "TextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeT" +
                "extSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSome" +
                "TextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTex" +
                "tSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSo" +
                "meTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTex" +
                "tSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSom" +
                "eTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSom" +
                "eTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSo" +
                "meTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeT" +
                "extSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeTextSomeText"),
        ModelFood(R.drawable.im_french_fries, "French Fries", "SomeText"),
        ModelFood(R.drawable.im_pasta, "Pasta", "SomeText"),
        ModelFood(R.drawable.im_pizza, "Pizza", "SomeText"),
        ModelFood(R.drawable.im_salad, "Salat", "SomeText"),
        ModelFood(R.drawable.im_sushi, "Sushi", "SomeText")
    )
}







