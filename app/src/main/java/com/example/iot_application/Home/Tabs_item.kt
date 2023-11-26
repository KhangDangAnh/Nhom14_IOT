package com.example.iot_application.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.iot_application.R

typealias MyFunction = @Composable () -> Unit
sealed class Tabs_item(
    var title : String,
    var screen : MyFunction,
    var icon : Int
){
    object Room_item :Tabs_item("Room",{ RoomScreen()}, R.drawable.baseline_home_24)
    object Device_item :Tabs_item("Device",{ DeviceScreen()},R.drawable.baseline_devices_other_24)
}
