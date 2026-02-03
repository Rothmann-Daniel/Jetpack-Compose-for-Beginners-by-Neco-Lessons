package com.danielrothmann.composelessonneco.bottom_navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController() // для сохраниения состояния навигации

    Scaffold(
        bottomBar = { BottomNavigationScreen(navController = navController) }
    ) { innerPadding ->
            // Используем ранее созданную функцию NavGraph
            NavGraph(
                navHostController = navController,
                modifier = Modifier.padding(innerPadding)
            )

    }
}