package com.example.iot_application.Room

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class NavRoute(val route:String){
    object ROOMSCRENN:NavRoute("roomscreen")
    object LIVINGROOM: NavRoute("livingroom")
    object KITCHENROOM: NavRoute("kitchenroom")
    object BEDROOM1: NavRoute("bedroom1")
    object BEDROOM2: NavRoute("bedroom2")
    object TOILET: NavRoute("toilet")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.ROOMSCRENN.route)
    {
        composable(NavRoute.LIVINGROOM.route){
            LivingRoom(navController)
        }
        composable(NavRoute.BEDROOM1.route){
            BedRoom1(navController)
        }
        composable(NavRoute.BEDROOM2.route){
            BedRoom2(navController)
        }
        composable(NavRoute.KITCHENROOM.route){
            KitChenRoom(navController)
        }
        composable(NavRoute.TOILET.route){
            Toilet(navController)
        }
    }
}

