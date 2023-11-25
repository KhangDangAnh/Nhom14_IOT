package com.example.iot_application.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

typealias MyFunction = @Composable () -> Unit
sealed class Tabs_item(
    var title : String,
    var screen : MyFunction,
    var icon : ImageVector
){
    object Room_item :Tabs_item("Room",{ RoomScreen()}, Icons.Default.Home)
    object Device_item :Tabs_item("Device",{ DeviceScreen()}, Icons.Default.Home)
}
