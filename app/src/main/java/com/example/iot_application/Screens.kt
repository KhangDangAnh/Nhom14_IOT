package com.example.iot_application

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chartiot.ChartScreen
import com.example.iot_application.Home.HomeScreen
import com.example.iot_application.Login.LoginScreen
import com.example.iot_application.Profile.Profile_Screen
import com.example.iot_application.Room.RoomScreen

sealed class Screens(val route: String) {
    object Login : Screens("Login_Screen")
    object Home : Screens("Home_Screen")
    object Profile : Screens("Profile_Screen")
    object Room : Screens("Room_Screen")
    object Chart : Screens("Chart_Screen")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Login.route)
    {
        composable(Screens.Login.route)
        {
            LoginScreen(navController)
        }
        composable(Screens.Profile.route)
        {
            Profile_Screen("Ng Van A",navController)
        }
        composable(Screens.Home.route)
        {
            HomeScreen(navController)
        }
        composable(Screens.Room.route)
        {
            RoomScreen(navController)
        }
        composable(Screens.Chart.route)
        {
            ChartScreen(
                mapOf(

                    Pair(2f, "2"),
                    Pair(20f, "3"),
                    Pair(21f, "4"),
                    Pair(40f, "5"),
                    Pair(52f, "6"),
                    Pair(22f, "7"),
                    Pair(62f, "CN"),


                    ), max_value = 60, navController
            )
        }
    }
}