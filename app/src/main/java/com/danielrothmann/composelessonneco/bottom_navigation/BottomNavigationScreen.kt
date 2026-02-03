package com.danielrothmann.composelessonneco.bottom_navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationScreen(navController: NavController) {
    val listBottomItems = listOf(
        BottomItem.Screen1,
        BottomItem.Screen2,
        BottomItem.Screen3,
        BottomItem.Screen4
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route


    NavigationBar( // Создание панели нижней навигации
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = NavigationBarDefaults.Elevation,
        windowInsets = NavigationBarDefaults.windowInsets,
        modifier = Modifier.fillMaxWidth()
    ) {
        listBottomItems.forEach { item ->
            NavigationBarItem( // Создание элемента панели нижней навигации
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) // Путь до экрана
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors( // Автоматические цвета
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer, // Цвет индикатора
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer, // Цвет иконки при выборе
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer, // Цвет текста при выборе
                    unselectedIconColor = Color.Gray, // Цвет иконки при невыборе
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}