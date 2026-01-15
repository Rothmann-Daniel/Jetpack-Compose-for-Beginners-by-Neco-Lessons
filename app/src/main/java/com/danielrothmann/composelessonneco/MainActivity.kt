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
import com.danielrothmann.composelessonneco.ui.theme.TsstColor1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Для белого статус-бара - разрешаем отрисовку за системными барами
        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                showMenu()
            }
        }
    }

    @Composable
    private fun showMenu() {
        val menu = createMenu()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)  // Фиксированная высота меню
                .background(Color.White)  // Белый фон для Box (будет виден в статус-баре)
        ) {
            // тестовый фон только для LazyRow
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)  // Высота LazyRow меньше чем у Box
                    .align(Alignment.BottomCenter)  // Размещаем внизу Box
                    .background(TsstColor1)  // Тестовый фон для LazyRow
                    .padding(horizontal = 8.dp, vertical = 16.dp)  // Отступы по бокам и сверху/снизу

            ) {
                itemsIndexed(menu) { index, itemShow ->
                    // Добавляем отступы между элементами
                    ItemFoodRow(
                        itemListFood = itemShow,
                        modifier = Modifier.padding(
                            start = if (index == 0) 0.dp else 8.dp,  // Первому элементу отступ слева не нужен
                            end = if (index == menu.lastIndex) 0.dp else 8.dp  // Последнему справа не нужен
                        )
                    )
                }
            }
        }
    }


    // Функция возвращает список, а не один элемент
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






