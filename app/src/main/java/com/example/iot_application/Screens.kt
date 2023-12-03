package com.example.iot_application

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chartiot.ChartScreen
import com.example.iot_application.Home.DeviceScreen
import com.example.iot_application.Home.HomeScreen
import com.example.iot_application.Home.RoomList
import com.example.iot_application.Login.LoginScreen
import com.example.iot_application.Profile.ChangePassword
import com.example.iot_application.Profile.Profile_Screen
import com.example.iot_application.Profile.changeProfile
import com.example.iot_application.Room.BedRoom1
import com.example.iot_application.Room.BedRoom2
import com.example.iot_application.Room.KitChenRoom
import com.example.iot_application.Room.LivingRoom
import com.example.iot_application.Room.Toilet

sealed class Screens(val route: String) {
    object Login : Screens("Login_Screen")
    object Home : Screens("Home_Screen")
    object Profile : Screens("Profile_Screen")
    object RoomKhach : Screens("RoomKhach_Screen")
    object RoomNgu1 : Screens("RoomNgu1_Screen")
    object RoomNgu2 : Screens("RoomNgu2_Screen")
    object RoomTam : Screens("RoomTam_Screen")
    object RoomBep : Screens("RoomBep_Screen")
    object Chart : Screens("Chart_Screen")

    object Room_list : Screens("RoomList_Screen")
    object Devices : Screens("Devices_Screen")

    object ChangProfile : Screens("Change_Profile")

    object ChangePassword : Screens("Change_Pass")
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
        composable(Screens.RoomKhach.route)
        {
            LivingRoom(navController)
        }
        composable(Screens.RoomNgu1.route)
        {
            BedRoom1(navController)
        }
        composable(Screens.RoomNgu2.route)
        {
            BedRoom2(navController)
        }
        composable(Screens.RoomBep.route)
        {
            KitChenRoom(navController)
        }
        composable(Screens.RoomTam.route)
        {
            Toilet(navController)
        }
        composable(Screens.Room_list.route)
        {
            RoomList(navController)
        }
        composable(Screens.Devices.route)
        {
            DeviceScreen(navController)
        }

        composable(Screens.ChangePassword.route)
        {
            ChangePassword(navController)
        }

        composable(Screens.ChangProfile.route)
        {
            changeProfile(navController)
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