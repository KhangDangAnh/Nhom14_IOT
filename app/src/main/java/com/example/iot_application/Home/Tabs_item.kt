package com.example.iot_application.Home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.iot_application.R

typealias MyFunction = @Composable () -> Unit
sealed class Tabs_item(
    var title : String,
    var screen : MyFunction,
    var icon : Int
){
    object Room_item :Tabs_item("Room",{ RoomList()}, R.drawable.baseline_home_24)
    object Device_item :Tabs_item("Device",{ DeviceScreen()},R.drawable.baseline_devices_other_24)
}
