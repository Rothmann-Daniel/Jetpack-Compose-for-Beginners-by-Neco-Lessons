package com.danielrothmann.composelessonneco.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController, // Контроллер навигации, передаваемый из родительского компонента
    modifier: Modifier = Modifier
) {
    /**
     * NavHost - контейнер для навигации, который:
     * 1. Отображает текущий экран на основе стека навигации
     * 2. Управляет переходами между экранами
     * 3. Сохраняет состояние каждого экрана
     *
     * @param navController Контроллер для управления навигацией
     * @param startDestination Начальный экран, который показывается при запуске приложения
     *                        или когда стек навигации пуст.
     */
    NavHost(
        navController = navHostController, // Контроллер, переданный извне
        startDestination = "screen_1"      // Начальный экран при запуске приложения
    ) {
        /**
         * Определение экрана с маршрутом "screen_1".
         * Когда пользователь переходит на этот маршрут, отображается компонент Screens1().
         *
         * Маршруты должны соответствовать route параметрам в BottomItem объектах:
         * - BottomItem.Screen1.route = "screen_1"
         */
        composable("screen_1") {
            Screens1() // Экран 1 приложения
        }
        composable("screen_2") {
            Screens2()
        }
        composable("screen_3") {
            Screens3()
        }
        composable("screen_4") {
            Screens4()
        }
    }
}

