package com.danielrothmann.composelessonneco.bottom_navigation

import com.danielrothmann.composelessonneco.R

sealed class BottomItem (val title: String, val iconId: Int, val route: String){
    object Screen1: BottomItem(
        title = "Screen1",          // Текст ПОД иконкой
        iconId = R.drawable.ic_1,   // Сама иконка
        route = "screen_1"          // Маршрут для навигации
    )
    object Screen2: BottomItem(
        title = "Screen2",
        iconId = R.drawable.ic_2,
        route = "screen_2"
    )
    object Screen3: BottomItem(
        title = "Screen3",
        iconId = R.drawable.ic_3,
        route = "screen_3"
    )
    object Screen4: BottomItem(
        title = "Screen4",
        iconId = R.drawable.ic_4,
        route = "screen_4"
    )
}